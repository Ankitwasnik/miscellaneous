## workflow-user-login 
This module is created to help developers to automate login of users on EMTECH sandbox. 
The login script will read all the users from the resources/department-users.json file and will login each user in a separate tab. This script uses selenium to automate the process.

### Pre-requisite
1) Firefox browser
2) Firefox Multi-Account Containers Extension --> https://addons.mozilla.org/en-US/firefox/addon/multi-account-containers/?utm_source=addons.mozilla.org&utm_medium=referral&utm_content=search
3) Open external links in a container Extension --> https://addons.mozilla.org/en-US/firefox/addon/open-url-in-container/
4) Create a new profile in firefox and add the above extensions. To create new profile on windows, 
5) use keys win + R and run firefox.exe -p. You can use existing profile but if it has lots of extensions already installed, it will slow down the script.
6) Update firefox profile path (FF_PROFILE_PATH) variable according to your system.
7) Update the department-users.json file according to the env users.
8) Once this is done, you can run the LoginScript.java.

### Note
1) This script is not quitting the driver(geckodriver) as we do not want the window to be closed after the script is executed. Do it manually.

### Future Improvement
1) Instead of hardcoding profile path and URL, we can pass it as program arguments.
2) We can update the script to pick users according to env. We can create separate files for each env users.
3) We can create a new profile and add extensions using the script instead of pre-creating it.
