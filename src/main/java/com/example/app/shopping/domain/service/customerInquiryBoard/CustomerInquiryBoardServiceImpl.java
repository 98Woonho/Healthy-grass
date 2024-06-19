package com.example.app.shopping.domain.service.customerInquiryBoard;

import com.example.app.shopping.domain.dto.CustomerInquiryBoardDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.dto.common.PageDto;
import com.example.app.shopping.domain.mapper.CustomerInquiryBoardMapper;
import com.example.app.shopping.properties.FileUploadPathProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CustomerInquiryBoardServiceImpl implements CustomerInquiryBoardService {

    @Autowired
    private CustomerInquiryBoardMapper mapper;

    @Override
    @Transactional
    public Map<String, Object> getCustomerInquiryBoards(Criteria criteria) throws Exception {
        // 검색 결과로 나오는 게시글 수 확인
        int count = mapper.findCustomerInquiryBoardsCount(criteria);
        PageDto pageDto = new PageDto(count, criteria);

        // 시작 게시물 번호 구하기
        int offset = (criteria.getPageno() - 1) * criteria.getAmount();

        List<Map<String, Object>> list = mapper.findCustomerInquiryBoards(criteria, offset);

        Map<String, Object> returnVal = new HashMap<>();
        returnVal.put("list", list);
        returnVal.put("pageDto", pageDto);

        return returnVal;
    }

    // id 를 전달받아 상품 문의 게시판을 상세 조회한 결과를 반환한다
    @Override
    @Transactional
    public Map<String, Object> getCustomerInquiryBoardDetail(Integer id) throws Exception {
        return mapper.findCustomerInquiryBoardById(id);
    }

    @Override
    @Transactional
    public Map<String, Object> getMyCustomerInquiryBoards(Criteria criteria, String uId) throws Exception {
        // 검색 결과로 나오는 게시글 수 확인
        int count = mapper.findMyCustomerInquiryBoardsCount(criteria, uId);
        PageDto pageDto = new PageDto(count, criteria);

        // 시작 게시물 번호 구하기
        int offset = (criteria.getPageno() - 1) * criteria.getAmount();

        List<Map<String, Object>> list = mapper.findMyCustomerInquiryBoards(criteria, offset, uId);

        Map<String, Object> returnVal = new HashMap<>();
        returnVal.put("list", list);
        returnVal.put("pageDto", pageDto);

        return returnVal;
    }

    @Override
    public Map<String, Object> postCustomerInquiryServ(CustomerInquiryBoardDto boardDto, MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();

        if (file != null && !file.isEmpty()) {
            String relativeDir = "customerInquiry/" + LocalDate.now();
            String uploadDir = FileUploadPathProperties.getUploadDir() + "/" + relativeDir;
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs(); // 디렉터리가 존재하지 않으면 생성
            }

            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
            String filePath = Paths.get(uploadDir, uniqueFileName).toString();

            File destinationFile = new File(filePath);
            try {
                file.transferTo(destinationFile);
            } catch (IOException e) {
                throw new Exception("파일 업로드에 실패했습니다.");
            }

            // boardDto에 파일 경로와 파일 이름 설정 (상대 경로 사용)
            boardDto.setImgPath("/uploads/" + relativeDir);
            boardDto.setImgName(uniqueFileName);
        }

        boardDto.setRegDate(LocalDate.now());
        boardDto.setUpdateDate(LocalDate.now());

        Integer insertReturnVal = mapper.insertCustomerInquiry(boardDto);

        if (insertReturnVal < 1) {
            // 삽입 실패 시
            throw new Exception("게시글 등록에 실패하였습니다.");
        } else {
            result.put("success", true);
            result.put("msg", "게시글 등록에 성공하였습니다.");
        }

        return result;
    }
}
