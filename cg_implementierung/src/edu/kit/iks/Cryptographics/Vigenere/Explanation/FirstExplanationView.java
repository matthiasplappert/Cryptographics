package edu.kit.iks.Cryptographics.Vigenere.Explanation;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import edu.kit.iks.Cryptographics.Vigenere.VigenereModel;
import edu.kit.iks.CryptographicsLib.CharacterFrequencyDiagramView;
import edu.kit.iks.CryptographicsLib.ImageView;
import edu.kit.iks.CryptographicsLib.Logger;
import edu.kit.iks.CryptographicsLib.VisualizationView;

/*
 * This class represents the view of the first explanatation step. In the first step the disadvantages
 * and possible weak points of the vigenere-cipher.
 */
public class FirstExplanationView extends VisualizationView{
	private static final long serialVersionUID = 6294968461280032987L;
	
	//Visulisation of the Key
	private JLabel vigenereWeakExplanatation;
	
	private static final String vigenereText = "NEVER GONNA GIVE YOU UP NEVER GONNA LET "
			+ "YOU DOWN NEVER GONNA RUN AROUND AND DESERT YOU "
			+ "NEVER GONNA MAKE YOU CRY NEVER GONNA SAY GOODBYE "
			+ "NEVER GONNA TELL A LIE AND HURT YOU"
			+ "WE'VE KNOWN EACH OTHER FOR SO LONG "
			+ "YOUR HEART'S BEEN ACHING BUT YOU'RE TOO SHY TO SAY IT "
			+ "INSIDE WE BOTH KNOW WHAT'S BEEN GOING ON "
			+ "WE KNOW THE GAME AND WE'RE GONNA PLAY IT";
	private static final String vigenereEncrypted = "BOJOF QCXBK USJO MYI ED XSFSB UYBXO VSD MYI NCGB "
			+ "XSFSB UYBXO BIX OBCEBN OXR NSCSBH ICE "
			+ "BOJOF QCXBK AKYO MYI MFI BOJOF QCXBK GKM QCYRLMO "
			+ "BOJOF QCXBK HOZV O VWO OXR RIBH ICE"
			+ "KO'JO YXCGB OOMV YHRSB TYF CC VCXU "
			+ "ICEF RSKFD'G LSOB KQRWXU LID MYI'BS DCY GRM DC COI WD "
			+ "WXGSRO KO PYHR YXCG KROD'G LSOB QCSBQ CX "
			+ "KO YXCG HRS QOWS KBN KO'FO UYBXO ZZKM SH";
	private static final String averageText = "HEREUPON LEGRAND AROSE, WITH A GRAVE AND STATELY AIR, AND BROUGHT ME THE BEETLEFROM A GLASS CASE "
			+ "IN WHICH IT WAS ENCLOSED. IT WAS A BEAUTIFUL SCARABAEUS, AND, AT"
			+ "THAT TIME, UNKNOWN TO NATURALISTS—OF COURSE A GREAT PRIZE IN A SCIENTIFIC POINT"
			+ "OF VIEW. THERE WERE TWO ROUND BLACK SPOTS NEAR ONE EXTREMITY OF THE BACK, AND A"
			+ "LONG ONE NEAR THE OTHER. THE SCALES WERE EXCEEDINGLY HARD AND GLOSSY, WITH ALL THE"
			+ "APPEARANCE OF BURNISHED GOLD. THE WEIGHT OF THE INSECT WAS VERY REMARKABLE, AND,"
			+ "TAKING ALL THINGS INTO CONSIDERATION, I COULD HARDLY BLAME JUPITER FOR HIS OPINION"
			+ "RESPECTING IT.";
	private static final String encryptedAverageText = "VOFOIZCX ZOUBOXR KFYGO, KSHR O QFKJO OXR CHKHOZI OSF, KBN PBCEURH WS DVO POSDZO"
			+ "TBCW O QZKGC QKGO WX KRWMV SH GOC SXQVCCSN. WD KKG K POOEHSTEZ CQKFKPKSEG, KBN, OD"
			+ "HROD HSAO, IXYXCGB DC XODIBOVWCHC—CP QYIBGO O QFOOD DBWJS SB K GMWOBDWPWM DYWXH"
			+ "YT FWOK. DVOFO KOFO HGC BCEBN PVOMY CDYHC BOOB CXS OLDFOASHI CP HRS LOMY, KBN O"
			+ "VCXU YBO BOOB HRS YHRSB. HRS CQKZOG GSBS OLMSORSBQZI VKFN OXR QZYGCM, GWDV KZV HRS"
			+ "KDZSKFKBMS YT LIBBSGRSN UYZN. HRS GSSURH YT DVO WXGOQD KKG FSBM BSWOBYKPVS, KBN,"
			+ "HKYSBQ OVZ DVSBQG SBDC MCXGSROFKHSCX, W MCEZN VKFNZI PVOWS TIZWDSB TYF RWC CZWXWYB"
			+ "BSCDOQDWXU SH.";
	private CharacterFrequencyDiagramView vigenereHistogramm;
	private CharacterFrequencyDiagramView averageHistogramm;
	private JLabel explanation;
	private JLabel secondExplanation;
	private JLabel thirdExplanation;
	
	public FirstExplanationView() {
		this.setLayout(null);
		this.add(new JLabel("VIGENERE EXPLANATATION"));
		this.add(this.explanation = new JLabel("<html><div width=\"1200\">Vigenere fixed a few weaknesses of Caesar, but still has flaws. If the key is shorter then the text to encrypt,"
       		+ "vigenere simply concatinates it with itself until the key is long enough. This again makes it weak against key-length-guessing (we will use kasiski test for it)."
       		+ "As soon as we guess the key-length, we can use a histogramm (explained in caesar) to make a static analysis. Here we see the Histogramm of every second character (encrypted with a key-length of 2) from the encrypted message:</div></html>"));
		this.explanation.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		this.add(this.secondExplanation = new JLabel("<html><div width=\"1200\">This is the average distribution of the characters in english texts:</div></html>"));
		this.secondExplanation.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		this.add(this.thirdExplanation = new JLabel("<html><div width=\"1200\">When we look closer at the histogramm we see some differences in the distribution of the characters; 'S' is has the most common occurance,"
				+ "in an average normal english text 'E' is the most common one. So maybe our 'S' couldve been an 'E' before the encryption. So we do 19(position of 'S') - 5 (position of 'E') and we get 14, which means"
				+ "the first character of the key is 'N'. If we do the same w</div></html>"));
		this.thirdExplanation.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		this.vigenereHistogramm = new CharacterFrequencyDiagramView(VigenereModel.getCharPositionated(2, encryptedAverageText), 600,
				100);
		this.add(this.vigenereHistogramm);
		
		this.averageHistogramm = new CharacterFrequencyDiagramView(averageText, 600,
				100);
		this.add(this.averageHistogramm);
		
		Dimension size = this.explanation.getPreferredSize();
		this.explanation.setBounds(10, 10,
	             size.width, size.height);
		size = this.secondExplanation.getPreferredSize();
		this.secondExplanation.setBounds(10, 240,
	             size.width, size.height);
		size = this.thirdExplanation.getPreferredSize();
		this.thirdExplanation.setBounds(10, 420,
	             size.width, size.height);
		
		this.vigenereHistogramm.setBounds(10, 140,
	             600, 100);
		this.averageHistogramm.setBounds(10, 280,
	             600, 100);
		Logger.l(VigenereModel.getCharPositionated(2, vigenereText));
	}
}