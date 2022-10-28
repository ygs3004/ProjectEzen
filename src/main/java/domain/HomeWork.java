package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeWork {

    private int hwNo;
    private String hwName;
    private String hwContent;
    private String writer;
    private Date hwRegDate;
    private Date hwDeadLine;

}
