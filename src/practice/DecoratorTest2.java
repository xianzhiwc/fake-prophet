package practice;

//Component Ӣ�۽ӿ� 
 interface Hero {
  //ѧϰ����
  void learnSkills();
}
//ConcreteComponent ����Ӣ��äɮ
 class BlindMonk implements Hero {
  
  private String name;
  
  public BlindMonk(String name) {
      this.name = name;
  }

  @Override
  public void learnSkills() {
      System.out.println(name + "ѧϰ�����ϼ��ܣ�");
  }
}
//Decorator ������
 class Skills implements Hero{
  
  //����һ��Ӣ�۶���ӿ�
  private Hero hero;
  
  public Skills(Hero hero) {
      this.hero = hero;
  }

  @Override
  public void learnSkills() {
      if(hero != null)
          hero.learnSkills();
  }    
}
//ConreteDecorator ���ܣ�Q
 class Skill_Q extends Skills{
  
  private String skillName;

  public Skill_Q(Hero hero,String skillName) {
      super(hero);
      this.skillName = skillName;
  }

  @Override
  public void learnSkills() {
      System.out.println("ѧϰ�˼���Q:" +skillName);
      super.learnSkills();
  }
}
//ConreteDecorator ���ܣ�W
 class Skill_W extends Skills{

  private String skillName;

  public Skill_W(Hero hero,String skillName) {
      super(hero);
      this.skillName = skillName;
  }

  @Override
  public void learnSkills() {
      System.out.println("ѧϰ�˼���W:" + skillName);
      super.learnSkills();
  }
}
//ConreteDecorator ���ܣ�E
 class Skill_E extends Skills{
  
  private String skillName;
  
  public Skill_E(Hero hero,String skillName) {
      super(hero);
      this.skillName = skillName;
  }

  @Override
  public void learnSkills() {
      System.out.println("ѧϰ�˼���E:"+skillName);
      super.learnSkills();
  }
}
//ConreteDecorator ���ܣ�R
 class Skill_R extends Skills{    
  
  private String skillName;
  
  public Skill_R(Hero hero,String skillName) {
      super(hero);
      this.skillName = skillName;
  }
  
  @Override
  public void learnSkills() {
      System.out.println("ѧϰ�˼���R:" +skillName );
      super.learnSkills();
  }
}
//�ͻ��ˣ��ٻ�ʦ
public class DecoratorTest2 {
  public static void main(String[] args) {
      //ѡ��Ӣ��
      Hero hero = new BlindMonk("����");
      
      Skills skills = new Skills(hero);
      Skills r = new Skill_R(skills,"������β");
      Skills e = new Skill_E(r,"������/�ݽ�Ϲ�");
      Skills w = new Skill_W(e,"������/������");
      Skills q = new Skill_Q(w,"������/������");
      //ѧϰ����
      q.learnSkills();
  }
}
