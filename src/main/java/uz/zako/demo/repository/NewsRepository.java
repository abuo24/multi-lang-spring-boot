package uz.zako.demo.repository;// Author - Orifjon Yunusjonov 
// t.me/coderr24

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.zako.demo.entity.News;
import uz.zako.demo.entity.translates.NewsTranslate;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
}
