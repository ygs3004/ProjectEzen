package domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;


@Data
@RequiredArgsConstructor
public class HomeWorkInfo {

    private String hwName;
    private String hwContent;
    private String writer;
    private Date hwRegDate;
    private Date hwDeadLine;
    private int completeMentee;

}
