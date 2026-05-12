package io.github.marcelosrg.email.dto;

import java.util.UUID;

public record EmailDto(UUID userId,
                       String emailTo,
                       String emailFrom,
                       String emailSubject,
                       String emailBody) {
}
