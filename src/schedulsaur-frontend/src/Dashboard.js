import React, { Component } from 'react';
import './App.css';
import Circle from 'react-circle';

class App extends Component {
  render() {
    return (
      <div class="all">
          <div class="top_zone">
            <p> Schedulsaur </p>
          </div>
          <div class="bot_zone">
              <div class="sidebar">
                {/* Yes, I will make this pretty later. Don't worry about it */}
                <a href="#">Dashboard</a>
                <a href="#">Course History</a>
                <a href="#">Time Availability</a>
                <a href="#">Desired Courses</a>
                <a href="#">Create Schedules</a>
                <a href="#">Saved Schedules</a>
                <a href="#">Help</a>
                <a href="#">About</a>
                <a href="#">Log Out</a>
              </div>
              <div class="main">
                {/* PLEASE ONLY PUT STUFF IN THIS DIV (WITH CLASS "main")
                 YOU CAN MAKE AS MUCH STUFF AS YOU WANT IN HERE
                 JUST NOT ANYWHERE ELSE */}


                {/* Now that I have your attention, here are some guidelines:
                    - Please don't touch anything not in this div.
                    - Please don't touch any CSS that isn't in this div. It can
                      break the template and then everything you make could be off.
                        - You can add CSS below line 79 in App.css if you want.
                        - I reserve the right to tweak any and all CSS to make it how I like it
                    - Re: the buttons at the bottom:
                        - If your page DOES NOT have either one, delete them.
                        - If your page has just the one on the right, delete the left one.
                        - Don't reposition them.
                    - My screenshot layouts are at the resolution of 1360x768.
                        - Yes I know my computer has a weird resolution.
                        - Please try to make them fit in this size.
                        - Please do not hardcode in position values if they don't fit on
                          my 1360x768 screen. Just because it fits on your screen doesn't mean
                          it'll look the same on mine.
                        - Please try to use ratios instead of hard pixel measurements.
                            - Key word is "try". If it doesn't work, use pixels, but if you use pixels
                              try to make it match up with the mockup screenshots.
                    - I will change fonts later. (This means don't bother importing Montserrat.)
                    - Schedulsaur Green is #5ea181. (named schedulsaur_green in the css file.)
                    - Shades of grey tend to vary. Just, uh, stick to these if you're adding grays.
                        - Light gray: #ececec (named light_grey in the css file.)
                        - Middle gray: #dddddd (named middle_grey in the css file.)
                        - Dark gray: #8b8b8b (named dark_grey in the css file.)
                    - Tommy, here's some color codes:
                        - major: #ffff99 (named major_class in the css file.)
                        - support: #ffcc99 (named support_class in the css file.)
                        - ge: #b3dfb3 (named ge_class in the css file.)
                 */}
                <h2 align="center">Dashboard</h2>
                 <div class="row">
                  <div class="column">
                  {/*Progress Wheel adjustments https://github.com/zzarcon/react-circle*/}
                    <div align="center">
                      <Circle
                        progress="10"
                        size = "250"
                        textColor=  "#8b8b8b"
                        progressColor= '#5ea181'
                      />
                    </div>
                  <p align="center"> Degree Progress</p>

                  </div>
                  <div class="column">
                  <p>
                  <b>Name :</b> John Doe <br/>
                  <b>Major:</b> Software Engineering <br/><br/>

                  <b>Catalog year:</b> 2017-2019 <br/>
                  <b>Expected graduation:</b> Spring 2020 <br/><br/>

                  <b>Units this quarter:</b> 16 units <br/>
                  <b>Units per quarter</b>: 14.5 units<br/>

                   </p>
                  </div>
                </div>
                 <div class="button" id="button_left">
                    <a>Edit Profile</a>
                 </div>
                 <div class="button" id="button_right">
                    <a>Save</a>
                 </div>

              </div>
          </div>
      </div>
    );
  }
}

export default App;
