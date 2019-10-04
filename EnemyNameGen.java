/*
 * @author Dalton
 *
 */



import java.util.Random;

public class EnemyNameGen
{

  private String[] fName;
  private String[] lName;
  private String[] title;
  private String[] desc;
 
  public void configLists(String[] args)
  {
    Random rand = new Random();
    int kids = rand.nextInt(15);
    int titleYN = rand.nextInt(2);
   

 
   
    fName = new String[]{"Bob","Tom","Bill","Zargathrax","Ralph","Michel","Yim","Allen","Austin","Todd","Lisa","Mike", "Jill","Ryan","Conner","Jack","Robby","Rick", "Boe","Fluffy","CuitiePie","Justine",
    "Carla", "Molly","Chris","Spencer","Greg","Nick","Muffins","Kirito","Asuna","Leluch","Rangnar", "Lilth", "Addison", "Loki","Dalton","Buzz","OwO","UwU","OxO","^U^" };
    lName = new String[]{"Kemp","Kratz","Ratty","Baddy","Lad","Rudoplh","Holdings","Naus","Bashem","Bander","lothbrook","Adams","Rounder","Cupcakes","Huggybear","McFluff","Ranger","LightYear","McLovin", "Crystal",
      "Ranglinger","Guts","Rebdak","Swan","Rabid","OWO","UwU","Lenny","Java","Gauva"};
    title = new String[]{"THE DESTROYER","The confused","of banderville","The killer","The inglorious","The victorious","The ladies man","Mom lover"};
    desc = new String[]{"Has a wife and " + kids + " kids", "He finna kill you","*Pounces on you UwU","Wants to give you huggie wuggies", "Just your everyday bandito","Played despacito 1 too many times",
    "He want's two number 9s, a number 9 large, a number 6 with extra dip, a number 7, two number 45s, one with cheese, and a large soda.","He just got out of jail",
      "He remebers the allamo", "Has a bright future ahead of him ", "Joins the fray" , "Jumps into battle" , "You there you're finnally awake", "Talos the mighty! Talos the unerring! Talos the unassailable! To you we give praise!Talos the mighty! Talos the unerring! Talos the unassailable! To you we give praise!"  };
    String name1 = fName[rand.nextInt(fName.length)];
    String name2 = lName[rand.nextInt(lName.length)];
    String title1 = title[rand.nextInt(title.length)];
    String desc1 = desc[rand.nextInt(title.length)];
    if(titleYN == 0){System.out.println(name1 + " " + name2);
      System.out.println("Description: " + desc1);}
    if(titleYN == 1){System.out.println(name1 + " " + name2 + " " + title1);
      System.out.println(desc1);}  
     /*
      * Talos the mighty! Talos the unerring! Talos the unassailable! To you we give praise!
We are but maggots, writhing in the filth of our own corruption! While you have ascended from the dung of man, and now walk among the stars!

But you were once man! Aye! And as man, you said, "Let me show you the power of Talos Stormcrown, born of the North, where my breath is long winter. I breathe now, in royalty, and reshape this land which is mine. I do this for you, Red Legions, for I love you."

Aye, love. Love! Even as man, great Talos cherished us. For he saw in us, in each of us, the future of Skyrim! The future of Tamriel!

And there it is, friends! The ugly truth! We are the children of man! Talos is the true god of man! Ascended from flesh, to rule the realm of spirit!

The very idea is inconceivable to our Elven overlords! Sharing the heavens with us? With man? Ha! They can barely tolerate our presence on earth!

Today, they take away your faith. But what of tomorrow? What then? Do the elves take your homes? Your businesses? Your children? Your very lives?

And what does the Empire do? Nothing! Nay, worse than nothing! The Imperial machine enforces the will of the Thalmor! Against its own people!

So rise up! Rise up, children of the Empire! Rise up, Stormcloaks! Embrace the word of mighty Talos, he who is both man and Divine!

For we are the children of man! And we shall inherit both the heavens and the earth! And we, not the Elves or their toadies, will rule Skyrim! Forever!

Terrible and powerful Talos! We, your unworthy servants, give praise! For only through your grace and benevolence may we truly reach enlightenment!

And deserve our praise you do, for we are one! Ere you ascended and the Eight became Nine, you walked among us, great Talos, not as god, but as man!

Trust in me, Whiterun! Trust in the words of Heimskr! For I am the chosen of Talos! I alone have been anointed by the Ninth to spread his holy word!
      * */

  }
}
