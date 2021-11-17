# android-mockwebserver


1.	Download Android Studio
   https://developer.android.com/studio/index.html

Click “Download Android Studio”, accept the terms and conditions, and proceed with the download.
The download might take a while, as it is about 700 MB. Run the installer after the download is finished.
2.	Install Android Studio
When running the installer, we recommend using the default values, as shown below. Once installed, Android Studio will run, and launch a setup wizard to download additional components.




3.	Run Android Studio Setup Wizard
When you first start Android Studio, it will offer to import any previous settings. Since this is likely your first installation, there are no settings to import. Again, just accept the default option and continue.

 
Next, select the UI theme. Choose whichever one you prefer -- this is simply a matter of preference. On the next screen, select the option to install an Android Virtual Device. You will need an actual Android device for this course, but this virtual device can be useful.


Accept the recommended RAM size for the emulator, and click “Next” to see a summary of the components to be downloaded. The additional components total about 1.8 GB in size.


When the download begins, the progress bar might appear to freeze, but do not worry -- the download is progressing. Once installation is complete, click “Finish”.

 
4.	Begin Developing
The Create New Project appears. The first option is to select the type of activity. Choose Empty, which is the default and click Next.
 

Configure your project is the next screen. It will ask for the name of the Application, Package Name, Project path, language, and API Level. Keep the defaults and click on Finish

 	 

Wait for it to finish. Once everything is downloaded and installed, the new project is created and you are taken to the Android workspace.
Create New Virtual Device
If you are starting the AVD Manager for the first time, you will see the following screen.  Else you will see the list of AVDs created.

 	 

In the left-hand panel displays a list of the Category of the device.  It includes TV, Phone, Wear & Tablet. Select the category.
The middle pane displays the list of devices available. Select one based on the requirement of your app. After this click on the Next button.
Note that phones with larger resolution Choose the pixels resolution according to your requirements as it will take huge RAM in large pixels resolution device. If your computer has low RAM, then prefer to choose less resolution device. Click Next to continue
 	 
Choose the system image based on the API level targeted by your App. The app won’t run if you choose lower API than the one target by the App,Select the image and click on Next to continue.
Here you can name your AVD, change startup orientation and few other hardware properties. Click on Show Advanced Settings to show more settings.
Click on Finish to create the AVD.
 
Under the action column, click on the   icon to run the AVD. The Android Emulator uses the AVD to mimic the device.  You can then use the control panel to manage the device. The Extend control button at the bottom gives you more options
MOCKITO
Mockito can be used as a mocking framework in Android. It allows us to fake external interactions
Mockito mock() method
It is used to create mock objects of a given class or interface. Mockito contains five mock() methods with different arguments. When we didn't assign anything to mocks, they will return default values. All five methods perform the same function of mocking the objects.
1.	when() method
It enables stubbing methods. It should be used when we want to mock to return specific values when particular methods are called. In simple terms, "When the XYZ() method is called, then return ABC." It is mostly used when there is some condition to execute.
 when(mock.someCode ()).thenReturn(5);
  thenReturn() is mostly used with the when() method.
2.	 verify() method
The verify() method is used to check whether some specified methods are called or not. In simple terms, it validates the certain behavior that happened once in a test.
3.	spy() method
Mockito provides a method to partially mock an object, which is known as the spy method. When using the spy method, there exists a real object, and spies or stubs are created of that real object. If we don't stub a method using spy, it will call the real method behavior. The main function of the spy() method is that it overrides the specific methods of the real object.
Following code snippet shows how to use the spy() method:
List spyArrayList = spy(ArrayList.class);
4.	reset() method
The Mockito reset() method is used to reset the mocks. It is mainly used for working with the container injected mocks. Usually, the reset() method results in a lengthy code and poor tests. It's better to create new mocks rather than using reset() method. That is why the reset() method is rarely used in testing.



     public static <T> void reset(T ... mocks)
     {  
      MOCKITO_CORE.reset(mocks);  
     }  
5.	Mockito doThrow() method
public static Stubber doThrow(Throwable toBeThrown) 
{  
       return MOCKITO_CORE.doAnswer(new ThrowsException(toBeThrown));  
    }  
6.	 doCallRealMethod() method
It is used when we want to call the real implementation of a method. In other words, it is used to create partial mocks of an object.:
public static Stubber doCallRealMethod() {
return MOCKITO_CORE.doAnswer(new CallsRealMethods());
}
7.	doAnswer() method
It is used when we want to stub a void method with a generic Answer type. 
public static Stubber doAnswer(Answer answer) {  
        return MOCKITO_CORE.doAnswer(answer);  
    } 
8.	times() method
It is used to verify the exact number of method invocations, which means it declares how many times a method is invoked. 
public static VerificationMode times(int wantedNumberOfInvocations) {  
        return VerificationModeFactory.times(wantedNumberOfInvocations);  
 }  



9.	never() method
It is used to verify that the interaction did not happen. 
public static VerificationMode never() {  
        return times(0);  
 }  
10.	 calls() method
It allows a non-greedy verification in order. It can only be used with the inOrder() verification method.
public static VerificationMode calls( int wantedNumberOfInvocations ){  
       return VerificationModeFactory.calls( wantedNumberOfInvocations );  
 }  
11.	 only() method
It checks that the given method was the only invoked method. 
public static VerificationMode only() {  
        return VerificationModeFactory.only();  
 }   
12.	 timeout() method
It allows Mockito to perform verification with a timeout. It instructs a verify to wait for a specific period of time for a particular interaction rather than to fail immediately. It may be useful for testing in existing situations.
public static VerificationWithTimeout timeout(long millis) {  
        return new Timeout(millis, VerificationModeFactory.times(1));  
 }  
13.	after() method
It allows Mockito to verify over a given period of time. We have already discussed that the after() method differs from the timeout() method.
public static VerificationAfterDelay after(long millis) {  
        return new After(millis, VerificationModeFactory.times(1));  
 }
Add dependency in build.gradle

dependencies {
    testImplementation("junit:junit:4.12")
    testImplementation('androidx.test:core:1.4.0')
    testImplementation("org.mockito:mockito-core:1.10.19")
}
Examples

public class PortfolioTester {
   public static void main(String[] args){
      Portfolio portfolio = new Portfolio();
      List<Stock> stocks = new ArrayList<Stock>();
      Stock googleStock = new Stock("1","Google", 10);
      Stock microsoftStock = new Stock("2","Microsoft",100);

      stocks.add(googleStock);
      stocks.add(microsoftStock);		
      StockService stockServiceMock = mock(StockService.class);

      when(stockServiceMock.getPrice(googleStock)).thenReturn(50.00);
      when(stockServiceMock.getPrice(microsoftStock)).thenReturn(1000.00);

      portfolio.setStocks(stocks);
      portfolio.setStockService(stockServiceMock);
      double marketValue = portfolio.getMarketValue();
   }
}




Let's understand the important concepts of the above program. The complete code is available in the chapter First Application.
Portfolio − An object to carry a list of stocks and to get the market value computed using stock prices and stock quantity.
Stock − An object to carry the details of a stock such as its id, name, quantity, etc.
StockService − A stock service returns the current price of a stock.
mock(...) − Mockito created a mock of stock service.
when(...).thenReturn(...) − Mock implementation of getPrice method of stockService interface. For googleStock, return 50.00 as price.
portfolio.setStocks(...) − The portfolio now contains a list of two stocks.
portfolio.setStockService(...) − Assigns the stockService Mock object to the portfolio.
portfolio.getMarketValue() − The portfolio returns the market value based on its stocks using the mock stock service.

