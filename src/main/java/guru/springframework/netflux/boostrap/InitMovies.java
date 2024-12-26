package guru.springframework.netflux.boostrap;

import guru.springframework.netflux.domain.Movie;
import guru.springframework.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;
    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll().thenMany(
                Flux.just("The Matrix", "The Matrix Reloaded", "The Matrix Revolutions")
                        .map(Movie::new)
                        .flatMap(movieRepository::save)
        ).subscribe(null, null, () -> movieRepository.findAll().subscribe(System.out::println));
    }
}
