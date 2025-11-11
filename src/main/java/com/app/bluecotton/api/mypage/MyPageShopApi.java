package com.app.bluecotton.api.mypage;

import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.domain.dto.MyReviewListDTO;
import com.app.bluecotton.domain.dto.ProductListResponseDTO;
import com.app.bluecotton.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/mypage/myshop/*")
public class MyPageShopApi {

    final ShopService shopService;

    @GetMapping("like/{memberId}")
    public ResponseEntity<ApiResponseDTO> getLikedProducts(@PathVariable Long memberId){
        List<ProductListResponseDTO> likedProducts = shopService.getLikedProducts(memberId);
        log.info("찜한 상품 조회 요청 : {}",  likedProducts);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("찜한 상품 조회 성공", likedProducts));
    }


    @GetMapping("review/{memberId}")
    public ResponseEntity<ApiResponseDTO> getMyReviews(@PathVariable Long memberId){
        log.info("마이리뷰 조회 요청 들어옴", memberId);

        List<MyReviewListDTO> myReviews = shopService.getMyReviews(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("마이리뷰 조회 성공", myReviews));
    }



}
