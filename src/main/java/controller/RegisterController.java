package view;

public class RegisterMenu extends Menu{
    public RegisterMenu(String name, Menu parent) {
        super(name, parent);
    }
    @Override
    public void show(){
        System.out.println("----------" + this.name +"----------" );
        System.out.println("Write back to return");
    }

    @Override
    public void execute() {
      Matcher matcher;
        Menu nextMenu = this;
      String input=getInputFromUser();
      if(matcher=Regex.getMatcher(input, Regex.createuser).matches())
        registeruser(matcher);
        nextMenu.show();
        nextMenu.execute();
    }
  public static void registeruser(Matcher matcher)
  {
     String username = matcher.group(1);
        String password =matcher.group(2);
        String password2 =matcher.group(3);
        String email = matcher.group(4);
    controller.RegisterController(String username,String password,String password2,String email);

  }
  }
