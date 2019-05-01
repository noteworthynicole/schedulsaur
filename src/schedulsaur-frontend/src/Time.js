import React, { Component } from 'react';
import './App.css';

function colorchange(id) {

    var background = document.getElementById(id).style.backgroundColor;
    if (background == "rgb(255, 145, 0)") {
        document.getElementById(id).style.background = "rgb(26,255,0)";
    } else {
        document.getElementById(id).style.background = "rgb(255,145,0)";
    }

}

class App extends Component {
  render() {
    return (
      <div class="all">
          <div class="header">
            <div class="logo"> Schedulsaur </div>
          </div>
          <div class="app-body">
              <div class="sidebar">
                {/* Yes, I will make this pretty later. Don't worry about it */}
                <button class="dashboard-button" key="1">Dashboard</button>
                <button class="sidebar-button" key="2">Course History</button>
                <button class="sidebar-button" key="3">Time Availability</button>
                <button class="sidebar-button" key="4">Desired Courses</button>
                <button class="sidebar-button" key="5">Create Schedules</button>
                <button class="sidebar-button" key="6">Saved Schedules</button>
                <button class="sidebar-button" key="7">Help</button>
                <button class="sidebar-button" key="8">About</button>
                <button class="sidebar-button" kay="9">Log Out</button>
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

                 <div class="row">
                  <div class="column">
                  <h2 align="center"> Saved Schedules </h2>
                  <p align="center">  </p>
                  <div class="ul" align="center">
                    <div class="li">
                      <a align="left">
                        Winter 2018
                      </a>
                      <a margin="10px">
                      </a>
                      <button class="buttonsaved" align="right">
                          <a>View</a>
                      </button>
                    </div>
                  </div>
    
                  </div>
                  <div class="column">
                    <h2 align="center"> Select When You Are Available </h2>
                    <h6 align="center">
                    Click all the boxes that correspond to the hours and days that you do not want to have class. Any white boxes will be considered free.
                    </h6>
                    <table id="tsch" align="center">
                    <tr><div class="calcolumn">
                      <th class="thsch">
                      Su
                      </th>
                      <th class="thsch">
                      M
                      </th>
                      <th class="thsch">
                      Tu
                      </th>
                      <th class="thsch">
                      W
                      </th>
                      <th class="thsch">
                      Th
                      </th>
                      <th class="thsch">
                      F
                      </th>
                      <th class="thsch">
                      Sa
                      </th>
                    </div></tr>
                    <tr><div class="calcolumn">
                      <td><a>
                      7-8 AM 
                      </a></td>
                      <td><button class="calbutton" id="Su78a" onclick="colorchange(id))">
                      </button></td>
                      <button class="calbutton" id="M78a" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="Tu78a" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="W78a" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="Th78a" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="F78a" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="Sa78a" onclick="colorchange(id)">
                      </button>
                    </div></tr>
                    <div class="calcolumn">
                      <a>
                      8-9am 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      9-10am 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      10-11am 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      11-12pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      12-1pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      1-2pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      2-3pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      3-4pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      4-5pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      5-6pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      6-7pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      7-8pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      8-9pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    <div class="calcolumn">
                      <a>
                      9-10pm 
                      </a>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                      <button class="calbutton" id="M78" onclick="colorchange(id)">
                      </button>
                    </div>
                    </table>
                  </div>
                </div>

                  <div class="button" id="button_create">
                    <a>Create New</a>
                  </div>
                 
                 <div class="button" id="button_left">
                    <a>Clear</a>
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
