# Star-Hotel
Based on JavaFX

JDK version: 9

IDE: IntelliJ IDEA 2017.2.5

Scene Builder 2.0 [Download](http://www.oracle.com/technetwork/java/javafxscenebuilder-1x-archive-2199384.html)

or [higher version](https://stackoverflow.com/questions/28808130/where-exactly-can-i-download-the-latest-version-of-scene-builder-for-java)

Code Style: [link](https://github.com/Dreampie/java-style-guide/blob/master/README.md)

Git Tool: SourceTree

* Add
``` java
CustomerModel newCustomer = new CustomerModel();

newCustomer.setFirstName(firstNameTextField.getText());
newCustomer.setSurname(surnameTextField.getText());
newCustomer.setContactNum(contactNumTextField.getText());
newCustomer.setGender(maleRadioButton.isSelected());
newCustomer.setFrequenter(defaulterCheckBox.isSelected());
newCustomer.setDefaulter(frequenterCheckBox.isSelected());
if (!postalCodeTextField.getText().isEmpty()) {
    newCustomer.setPostalCode(Integer.parseInt(postalCodeTextField.getText()));
}
newCustomer.setSuburb(suburbTextField.getText());
newCustomer.setAddress(addressTextField.getText());
if (stateChoiceBox.getValue() != null) {
    newCustomer.setState(stateChoiceBox.getValue().toString());
}

CustomerDAO dao = new CustomerDAOImpl();

if (om.equals(OpenMode.ADD)) {
    dao.insert(newCustomer);
} else if (om.equals(OpenMode.EDIT)) {
    newCustomer.setCustomerID(customerBuffer.getCustomerID());
    dao.update(newCustomer);
}
```
Add(DAO)
``` java

    public void insert(CustomerModel cm) {
        // TODO: check before insert...increment
        String insertRow = "INSERT INTO Customer(first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter) \n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertRow)) {
            pstmt.setString(1, cm.getFirstName());
            pstmt.setString(2, cm.getSurname());
            pstmt.setBoolean(3, cm.getGender() == "Male");
            pstmt.setString(4, cm.getContactNum());
            pstmt.setString(5, cm.getAddress());
            pstmt.setString(6, cm.getSuburb());
            pstmt.setString(7, cm.getState());
            pstmt.setInt(8, cm.getPostalCode());
            pstmt.setBoolean(9, cm.isDefaulter());
            pstmt.setBoolean(10, cm.isFrequenter());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
```
## DB Scheme
MySQL

int customer_id

String first_name

String surname

bool gender

String contact_num

String address

String suburb

String state

String postal code

bool defaulter

bool frequenter

## Tutorials

[Overall](https://wizardforcel.gitbooks.io/tutorialspoint-java/javafx/662.html)

[Overall 2](https://www.beibq.cn/book/2ajm633/15640)

[Overall 3](http://code.makery.ch/library/javafx-8-tutorial/zh-cn/)

[TutorialsPoint](http://tutorialspoint.howtolib.com/javafx/javafx_quick_guide.htm)

http://blog.csdn.net/ml3947/article/category/782398/3

[atnoce](https://atnoce.com/?cate=1)

[sixlab](https://blog.sixlab.cn/archives/category/java/javafx)

[Using SB in IDEA](http://docs.oracle.com/javase/8/scene-builder-2/work-with-java-ides/sb-with-intellij.htm#JSBID102)

Generate controller in IDEA: go to Scene Builder and click View > Show Sample Controller Skeleton. ([related qustion](https://stackoverflow.com/questions/26865596/no-injectable-field-found-in-fxml-controller-class))

[Quick Guide of SB](http://docs.oracle.com/javase/8/scene-builder-2/get-started-tutorial/jfxsb-get_started.htm#JSBGS101)

[Full Guide of SB](http://docs.oracle.com/javase/8/scene-builder-2/user-guide/index.html)

[Layout](http://blog.csdn.net/theonegis/article/details/50184811)

[tips](http://www.cnblogs.com/yinger/archive/2012/04/17/2453522.html)

[2D animation](https://coderknock.com/blog/2016/07/21/JavaFX.html)

[JDBC1](https://www.youtube.com/watch?v=h01xi3UI9lk)

[JDBC2](https://gist.github.com/jewelsea/4955598)

[JPA](https://www.youtube.com/watch?v=ylsEcbGEGxU) // we won't use it this time.

[several samples](http://365programperday.blogspot.com.au/2013/07/javafx-and-mysql-sample-illustration.html)

[Reactive](http://www.oschina.net/translate/building-reactive-systems-with-javafx)

[Disable some days from DatePicker](http://o7planning.org/en/11085/javafx-datepicker-tutorial)

## Samples
[Official](http://docs.oracle.com/javase/8/javafx/get-started-tutorial/get_start_apps.htm#JFXST804)

[Address Book](http://www.javafxchina.net/blog/2015/08/fxml_address_book/)

[Onepass](https://gitee.com/softxj/onepass4.0/)

[thb_client](https://gitee.com/qnloft/thb_client)

[student score](https://github.com/JeremieAstray/studentScoreAnalysis/tree/master/src/com/jeremie/scoreAnalysis/controller)

## Documentations

[JavaFX 8](http://docs.oracle.com/javase/8/javafx/api/)

[Controller](http://fxexperience.com/controlsfx/)

## markdown
https://github.com/guodongxiaren/README