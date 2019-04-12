# how to

Here's what I did (your mileage may vary b/c I'm on linux)

- Install [node.js](https://nodejs.org/en/) (I did 10.15.3 LTS)
- It should (?) come with npx/npm
- Follow [these instructions under the heading "Quick Overview"](https://github.com/facebook/create-react-app)
- You can probably just copy+paste two of my files into the app you make
  - I edited these two files: /src/App.js and /src/App.css
  - Hopefully that works

# guidelines
- Please don't touch anything not in the main div.
- Please don't touch any CSS that isn't in the main div. It can
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
