# java web raw post issue

exploring a surprising error when uploading binary files to a servlet on another
project.

## situation

binary data gets corrupted when we read from `reg.getInputStream()`

## findings

- gretty plugin has issues with tomcat
- `IOUtils.copy()` works as expected here but not on main project

still some work _to be done_
