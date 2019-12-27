# java web raw post issue

exploring a surprising error when uploading binary files to a servlet on another
project.

## basic usage

- at least java 8 and gradle 4.10.3

```bash
gradle appRun
```

## situation

binary data gets corrupted when we read from `reg.getInputStream()`

## findings

- gretty plugin has issues with tomcat
- `IOUtils.copy()` works as expected here but not on main project

still some work _to be done_
