package uz.zako.demo.repository.translates;
// Author - Orifjon Yunusjonov
// t.me/coderr24

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.zako.demo.entity.enums.LanguageEnum;
import uz.zako.demo.entity.translates.NewsTranslate;
import uz.zako.demo.payload.NewsPayload;

import java.util.List;

@Repository
public interface NewsTranslateRepository extends JpaRepository<NewsTranslate, Long> {

    @Query("select new uz.zako.demo.payload.NewsPayload(nt.news.id,nt.content, nt.title,nt.news.likes,  nt.languageEnum) from NewsTranslate nt where nt.news.id=?1 and nt.languageEnum=?2")
    NewsPayload findByLanguage(Long id, LanguageEnum languageEnum);

    @Query("select new uz.zako.demo.payload.NewsPayload(nt.news.id,nt.content, nt.title,nt.news.likes,  nt.languageEnum) from NewsTranslate nt where nt.languageEnum=?1")
    List<NewsPayload> findAllByLanguage(LanguageEnum languageEnum);

}


