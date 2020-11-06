#  Welcome to Rococoa

Rococoa is a generic Java binding to the Mac Objective-C object system. It 
allows the creation and use of Objective-C objects in Java, and the 
implementation of Objective-C interfaces in Java.

## Rococoa Acknowledgements
Rococoa owes much to the following people and organisations
  * [JNA](http://jna.dev.java.net) does all the heavy lifting of calling into Cocoa and marshaling parameters. Timothy Wall also added pass struct by value and other extension points to make our life simpler.
  * [Paul Loy](http://www.keteracel.com) was the alpha guinea-pig.
  * Simon Taylor, Gareth Sylvester-Bradley and Dion Crannitch for Objective-C help.
  * Richard Care, Matt Bowers, Andy Collins and Morgan David let it go.
  * [Apple Inc](http://www.apple.com) produced Quicktime, Java on Mac OS, the Cocoa-Java Bridge and Quicktime for Java, then killed at least 2 of them.
If you know Java and Cocoa your name could be on this list! [Get involved!](HelpWanted.md)

## Projects using Rococoa

_Make sure you comply with the GNU Lesser General Public License when releasing an application that uses Rococoa._

  * [Cyberduck](https://github.com/iterate-ch/cyberduck) - Libre file transfer client for macOS and Windows. Command line interface (CLI) for Linux, macOS and Windows.

## Documentation
 * [Building](Building.md)
 * [How To](HowTo.md)
 * [Take the Whistlestop Tour](WhistlestopTour.md)
 * [Limitations](Limitations.md)
 * [Memory](Memory.md)
 * [NIBLoading](NIBLoading.md)
 * [ObjcMsgSend](ObjcMsgSend.md)
 * [Quicktime](Quicktime.md)
 * [Help Wanted](HelpWanted.md)
 * [How To](HowTo.md)

## Change History
### 0.3.0
	* Functioning 64-bit (and hence Java 6) support
		thanks to Paul Loy for fixes and discussions, and Andy Thompson for NSInteger et al
	* We should now correctly l small structs as return values, not just NSSize!
	* Improved NSDictionary
	* Support for JNA-3.0.4		

### 0.2.0
	* Much more rigorous memory management.
	* Selectors are now cached on the Java side.
	* Fixed problem #9 where we could only have one delegate or notification 
		thanks to Adrian Ross for diagnosis and fix.
	* Much expanded set of parameter and return types for delegates and notifications
		thanks to Andy Thompson for suggestions and help.
	* Fix defect #10 where delegates and notifications failed after the autorelease 
		pool is released. Now use Rococoa.proxy rather than wrap.
	* Now use JNA-3.0.3 (NB slightly patched, please make sure that Rococoa precedes
		JNA in the classpath 

### 0.1.4
	* Reworked CFString handling to use UTF-8 and hence support extended characters.
	* Now support delegates and notifications, using Rococoa.wrap(Object)

### 0.1.3
	* Now ship a Universal Binary dylib
	
### 0.1.2
    * Added LGPL licence files and these release notes.

### 0.1.1
    * Changes to allow the checked-out code to build.

### 0.1.0
    * First published to dev.java.net.

