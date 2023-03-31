package org.student.demo.util.security.exception;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ExceptionReturn {
    private Boolean result;
    private String field;
    public String condition;
}
