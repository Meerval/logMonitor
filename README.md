# logMonitor
This program displays errors from a .log or .txt extesed file using text format:
```
yyyy-MM-dd HH:mm:ss [ddd] some text

yyyy-MM-dd HH:mm:ss [ddd] ERROR: some error
```
It is also formats text:

```
before:

2022-2-22 13:33:59 [105] ERROR: Some exception occurred
                         and it takes a few lines
                         Please do something
                         to identify them as good looking message

after:

2022-2-22 13:33:59 [105] ERROR: Some exception occurred and it takes a few lines
                         Please do something to identify them as good looking message
```

To try it use [src/main/java/logMonitor/LogMonitorDemo.java](https://github.com/Meerval/logMonitor/blob/master/src/main/java/logMonitor/LogMonitorDemo.java)

You also can display entire log using logMonitor.printEntireLog() instead logMonitor.printOnlyErrors()

To start all tests use [src/test/java/testSuite/LogMonitorTestsRunner.java](https://github.com/Meerval/logMonitor/blob/master/src/test/java/testSuite/LogMonitorTestsRunner.java)
