# Quokka
A toolkit for Android developing

## Dependency
1. Add jitpack maven repo
```
repositories {
  ...
  maven { url 'https://jitpack.io' }
}
```
2. Add dependency
```
dependencies {
  compile 'com.github.houxg:Quokka:0.1'
}
```

## Usage
### Init
Init Quokka at the beginning of your app
```
Quokka.init(context);
```
### CommandReceiver
Send custom command to your app via adb
#### add command listener
```
Quokka.subscribeCommand(new Subscriber<String>() {
            @Override
            public void onUpdate(Publisher<String> publisher, String data) {
                messageTv.setText("command:" + data);
            }
        });
```
#### send command

```
adb shell am broadcast -a quokka.action.command --es command "your custom command"
```
### Print
Print every int enum
