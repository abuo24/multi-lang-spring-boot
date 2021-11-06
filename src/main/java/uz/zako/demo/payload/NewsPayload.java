package uz.zako.demo.payload;// Author - Orifjon Yunusjonov 
// t.me/coderr24

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.demo.entity.enums.LanguageEnum;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsPayload {
    private Long id; //
    private String content; // diqqat - attention
    private String title; // salom - hello
    private Integer like; //10
    private LanguageEnum language; //uz
}
