import java.awt.*;

class SilnikKulki extends Thread
{
    Kulka a;

    SilnikKulki(Kulka a)
    {
        this.a=a;
        start();
    }

    public void run()
    {
        try
        {
            while(true)
            {
                a.nextKrok();
                int l  = Kulka.getLife();
                if (l == 0){
                    break;
                }
                sleep(15);


            }
        }
        catch(InterruptedException e){} catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }
}