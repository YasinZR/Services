package org.example.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@Document(collation = "users")
public class User {

    @Id
    private Integer id;
    private List<String> photos;
}
