package uz.zako.demo.service;// Author - Orifjon Yunusjonov 
// t.me/coderr24

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.zako.demo.entity.News;
import uz.zako.demo.entity.enums.LanguageEnum;
import uz.zako.demo.entity.translates.NewsTranslate;
import uz.zako.demo.exceptions.BadRequestException;
import uz.zako.demo.payload.NewsPayload;
import uz.zako.demo.repository.NewsRepository;
import uz.zako.demo.repository.translates.NewsTranslateRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository repository;
    private final NewsTranslateRepository translateRepository;

    public List<NewsPayload> save(List<NewsPayload> payload) {
        if (LanguageEnum.values().length == payload.size()) {
            News news = new News();
            news.setLikes(payload.get(0).getLike());
            News finalNews = repository.save(news);
            return payload.stream().peek(newsPayload -> {
                NewsTranslate translate = new NewsTranslate();
                translate.setTitle(newsPayload.getTitle());
                translate.setContent(newsPayload.getContent());
                translate.setLanguageEnum(newsPayload.getLanguage());
                translate.setNews(finalNews);
                translateRepository.save(translate).getId();
                newsPayload.setId(finalNews.getId());
            }).collect(Collectors.toList());
        } else throw new BadRequestException("langueges size is not valid");
    }

    public NewsPayload getOneByLanguage(Long id, LanguageEnum languageEnum) {
        return translateRepository.findByLanguage(id, languageEnum);
    }

    public List<NewsPayload> getAllByLanguage(LanguageEnum languageEnum) {
        return translateRepository.findAllByLanguage(languageEnum);
    }
}
