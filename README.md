ShadowDancer
============

## let's dance with the shadow

ShadowDancer converts  XML(created by [Kagemai](http://www.daifukuya.com/kagemai/)) to ticket that managed by other system.

We will support Services like

 - [Gitlab](https://www.gitlab.com/)
 - [Redmine](http://www.redmine.org/)


## Configuration

You must make configuration file what is named `DancerText`.

### Sample


```scala
DancerText { service =>
  service.redmine.entryPoint = "http://redmine.numa08.jp"
  service.redmine.token = "redminetoken"

  service.gitlab.entryPoint = "http://redmine.numa08.jp:8080"
  service.gitlab.token = "gitlabtoke"

  service.xmlPaths += "/Users/numanuma08/Documents/KagemaiProject/xml" as Gitlab at 1 on "http://kagemai.example.com/html/guest.cgi?project=Shadow_dancer"
}
```


### Syntax

 1. Set Redmine|Gitlab  entryPint and token
 1. Set xml directory path and Project setting
 	`service.xmlPaths += ${xml directory path} as ${Gitlab|Redmine} at ${project id} on ${Kagemain project url}`
