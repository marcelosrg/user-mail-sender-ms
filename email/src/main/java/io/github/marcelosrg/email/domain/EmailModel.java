package io.github.marcelosrg.email.domain;

import io.github.marcelosrg.email.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAIL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID emailId;
    private String emailTo;
    private String emailFrom;
    private String emailSubject;

    @Column(columnDefinition = "BODY")
    private String emailBody;
    private LocalDateTime sendDateEmail;
    private EmailStatus statusEmail;

}
