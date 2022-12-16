import javax.swing.*;

class App
{

  public static void initWindow()
  {
    // Create window and set title
    JFrame window = new JFrame("CoinsTaker");
    // Close the window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Board board = new Board();
    window.add(board);
    window.addKeyListener(board);
    window.setResizable(false);
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

  public static void main(String[] args)
  {

    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        initWindow();
      }
    });
  }
}
