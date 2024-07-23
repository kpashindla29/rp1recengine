package net.javajudd.rp1recengine.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private Random random = new Random();
    private static final int SONG_COUNT = 11;

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/user/{userId}/recommendation")
    public List<Integer> recommendations(@PathVariable("userId") int userId) {
        List<Integer> recommendedSongs = Arrays.asList(random(), random(), random());
        logger.info("User {} was recommended songs: {}", userId, recommendedSongs);
        return recommendedSongs;
    }

    private int random() {
        return random.nextInt(SONG_COUNT);
    }
}