package org.test.request.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.test.request.CommonRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor implements CommonRequest {
    private String actorName;
    private String from;
}
