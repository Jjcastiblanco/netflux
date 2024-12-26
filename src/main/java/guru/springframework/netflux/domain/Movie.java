package guru.springframework.netflux.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;

}
