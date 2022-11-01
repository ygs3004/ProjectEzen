package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;


@Data
@RequiredArgsConstructor
public class HomeWork {

    private String hwName;
    private String hwContent;
    private String writer;
    private Date hwRegDate;
    private Date hwDeadLine;
    private int completeMentee;

}
