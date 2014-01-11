package main;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ptatyana on 09.01.14.
 */

@Entity
@Table(name="lines")
public class Line {

    private static Logger logger = LoggerFactory.getLogger(Line.class);

    private Long id;
    private int score;
    public List<Frame> frames;

    public Line() {
        score = 10;
        frames = new ArrayList<Frame>(10);
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="line_id")
    public Long getId() {
        return id;
    }

    @Column(name="score")
    public int getScore() {
        return score;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @OneToMany
    @JoinColumn(name = "line_id")
    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }

    //-----------------------functionality
    public void roll(int pins) {
        frames.add(new Frame());
    }


}
