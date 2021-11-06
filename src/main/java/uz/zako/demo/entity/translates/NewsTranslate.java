package uz.zako.demo.entity.translates;// Author - Orifjon Yunusjonov 
// t.me/coderr24

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.demo.entity.News;
import uz.zako.demo.entity.enums.LanguageEnum;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsTranslate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;
    private String title;

    @Enumerated(EnumType.STRING)
    private LanguageEnum languageEnum;
    @ManyToOne
    private News news;
}
