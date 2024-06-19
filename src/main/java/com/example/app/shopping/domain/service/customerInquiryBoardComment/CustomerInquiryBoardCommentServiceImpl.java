package com.example.app.shopping.domain.service.customerInquiryBoardComment;

import com.example.app.shopping.domain.dto.CustomerInquiryCommentDto;
import com.example.app.shopping.domain.mapper.CustomerInquiryBoardCommentMapper;
import com.example.app.shopping.properties.FileUploadPathProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class CustomerInquiryBoardCommentServiceImpl implements CustomerInquiryBoardCommentService {

    @Autowired
    private CustomerInquiryBoardCommentMapper mapper;

    @Override
    public List<Map<String, Object>> getComments(Integer id) throws Exception {
        return mapper.findCommentsByCustomerInquiryBoardId(id);
    }

    @Override
    public Map<String, Object> postCommentServ(CustomerInquiryCommentDto commentDto, MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();

        if (file != null && !file.isEmpty()) {
            String relativeDir = "comments/" + LocalDate.now();
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

            // commentDto에 파일 경로와 파일 이름 설정 (상대 경로 사용)
            commentDto.setImgPath("/uploads/" + relativeDir);
            commentDto.setImgName(uniqueFileName);
        }

        // 데이터베이스에 댓글 저장 로직 추가
        int insertReturnVal = mapper.insertComment(commentDto);

        if (insertReturnVal < 1) {
            throw new Exception("댓글 등록에 실패하였습니다.");
        } else {
            result.put("success", true);
            result.put("msg", "댓글 등록에 성공하였습니다.");
        }

        return result;
    }

    @Override
    public Map<String, Object> deleteCustomerInquiryCommentServ(Long id) throws Exception {
        Map<String, Object> result = new HashMap<>();

        // 댓글 정보 가져오기
        CustomerInquiryCommentDto commentDto = mapper.selectCustomerInquiryCommentById(id);

        if (commentDto == null) {
            throw new Exception("해당 ID의 댓글을 찾을 수 없습니다.");
        }

        // 이미지 파일 삭제
        if (commentDto.getImgPath() != null && commentDto.getImgName() != null) {
            String filePath = FileUploadPathProperties.getUploadDir() + commentDto.getImgPath().replaceFirst("/uploads", "") + "/" + commentDto.getImgName();
            File file = new File(filePath);
            if (file.exists()) {
                boolean isDeleted = file.delete();
                if (!isDeleted) {
                    throw new Exception("이미지 파일 삭제에 실패했습니다.");
                } else {
                    System.out.println("파일 삭제 성공: " + filePath);
                }
            } else {
                System.out.println("삭제할 파일이 존재하지 않습니다: " + filePath);
            }
        }

        // 댓글 삭제
        int deleteReturnVal = mapper.deleteCustomerInquiryComment(id);

        if (deleteReturnVal < 1) {
            throw new Exception("댓글 삭제에 실패하였습니다.");
        } else {
            result.put("success", true);
            result.put("msg", "댓글 삭제에 성공하였습니다.");
        }

        return result;
    }



}
