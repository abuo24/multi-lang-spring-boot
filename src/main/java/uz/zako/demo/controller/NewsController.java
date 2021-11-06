package uz.zako.demo.controller;// Author - Orifjon Yunusjonov 
// t.me/coderr24

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.zako.demo.entity.enums.LanguageEnum;
import uz.zako.demo.payload.NewsPayload;
import uz.zako.demo.service.NewsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/news")
public class NewsController {
    private final NewsService service;

    @PostMapping("/")
    public List<NewsPayload> save(@RequestBody List<NewsPayload> payload){
        return service.save(payload);
    }

    @GetMapping("/{id}")
    public NewsPayload getOneByLanguage(@PathVariable Long id, @RequestParam LanguageEnum languageEnum){
        return service.getOneByLanguage(id,languageEnum);
    }
    @GetMapping("/lang/{id}")
    public NewsPayload getOneByLanguageAndId(@PathVariable Long id, HttpServletRequest request){
        String languageEnum = request.getHeader("lang");
        return service.getOneByLanguage(id,LanguageEnum.valueOf(languageEnum));
    }
}
