import React from 'react';
import styles from './About.module.css';

const About = (props) => {
    return(
        <div className={styles.about_container}>
            <div className={styles.title_offset}>
                <h1 className='title'>Schedulsaur</h1>
                <h5 className='title-description'>a friendly schedule finder</h5>
            </div>
            <div className={styles.info_container}>
                <div className={styles.text_container}>
                    <h6 className={styles.text}>
                        schedulsaur is a scheduling app designed by <br/>
                        cal poly students for cal poly students <br/>
                    </h6>
                </div>
                <div className={styles.text_container}>
                    <h6 className={styles.text}>
                        update you time availability, generate schedules <br/>
                        view degree progress and more <br/>
                    </h6>
                </div>
                <div className={styles.text_container}>
                    <h6 className={styles.text}>
                        happy scheduling {'<3'} <br/>
                        --team bulbasaur <br/>
                    </h6>
                </div>
                <div className={styles.button_container}>
                    <button className='green_button' onClick={props.history.goBack}>Back</button>
                </div>
            </div>
            <h6 className={styles.version}>version 0.1.0</h6>
            <footer className='footer'></footer>
        </div>
    );
}

export default About;