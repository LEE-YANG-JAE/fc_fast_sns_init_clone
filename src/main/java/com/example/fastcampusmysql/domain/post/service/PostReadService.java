package com.example.fastcampusmysql.domain.post.service;

import com.example.fastcampusmysql.domain.post.dto.DailyPostCount;
import com.example.fastcampusmysql.domain.post.dto.DailyPostCountRequest;
import com.example.fastcampusmysql.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostReadService {

    final private PostRepository postRepository;

    public List<DailyPostCount> getDailyPostCounts(DailyPostCountRequest request) {
        /*
            반환 값 -> 리스트 [작성일자, 작성회원, 작성 게시물 갯수]
            select createdDate, memberId, count(id)
            from Post
            where 1=1
            and memberId = :memberId
            group by cratedDate, memberId
         */
        return postRepository.groupByCreatedDate(request);
    }
}
