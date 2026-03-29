# *Pathologic* Script Sources
This repository contains script source code from *Pathologic*, as of 2015 development on *Pathologic Classic HD*. All scripts are written in the C++ programming language.

**.sc** files are script bases, corresponding to .bin files in the *Pathologic* **data/Scripts** directory.

**.sci** files are script includes, which are referenced by one or multiple .sc files. These do not compile into their own .bin files.

## Directory structure
Most script files are in the top level. Scripts related to UI menu functionality are found in the "UI" subfolder, while certain additional scripts are in the "Util" subfolder (the logic of this is unclear.)
