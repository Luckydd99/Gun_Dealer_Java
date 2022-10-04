import java.util.Scanner;

public class GunDealerGame {

	public static short[] cuoreGD(String[] mazzo, String[] cima, String[][] tavGioco, String numCol, String tavolo, short carteGiocate) {

		short[] posRigCol = {0,0};

		switch (numCol) {

		case "1":
			for (short i = 4; i >= 0; i--) {
				if (tavGioco[i][0].equals(tavolo)) {
					tavGioco[i][0]=cima[2];
					posRigCol[0] = i;
					posRigCol[1] = 0;
					break;
				}
			}
			break;

		case "2":
			for (short i = 4; i >= 0; i--) {
				if (tavGioco[i][1].equals(tavolo)) {
					tavGioco[i][1]=cima[2];
					posRigCol[0] = i;
					posRigCol[1] = 1;
					break;
				}
			}
			break;

		case "3":
			for (short i = 4; i >= 0; i--) {
				if (tavGioco[i][2].equals(tavolo)) {
					tavGioco[i][2]=cima[2];
					posRigCol[0] = i;
					posRigCol[1] = 2;
					break;
				}
			}
			break;

		case "4":
			for (short i = 4; i >= 0; i--) {
				if (tavGioco[i][3].equals(tavolo)) {
					tavGioco[i][3]=cima[2];
					posRigCol[0] = i;
					posRigCol[1] = 3;
					break;
				}
			}
			break;

		case "5":
			for (short i = 4; i >= 0; i--) {
				if (tavGioco[i][4].equals(tavolo)) {
					tavGioco[i][4]=cima[2];
					posRigCol[0] = i;
					posRigCol[1] = 4;
					break;
				}
			}
			break;

		default:
			System.out.println("Something, somewhere went terribly wrong!");

		}
		
		cima[2]=cima[1];
		cima[1]=cima[0];
		cima[0]=mazzo[carteGiocate+3];

		//--------------------------
		for (int i = 0; i < 3; i++) {
			System.out.print(cima[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(tavGioco[i][j] + " ");
			}
			System.out.println();
		}
		//--------------------------

		return posRigCol;

	}

	public static short eliminazione(String[][] tavGioco, short[] posRigCol, String tavolo) {
		short carteElim = 0;
		String[] valRig = new String[5];
		String[] semRig = new String[5];
		/*String[] valCol = {tavolo, tavolo, tavolo, tavolo, tavolo};
		String[] semCol = {tavolo, tavolo, tavolo, tavolo, tavolo};
		String[] valsotsotD = {tavolo, tavolo, tavolo};
		String[] semsotsotD = {tavolo, tavolo, tavolo};
		String[] valsotD = {tavolo, tavolo, tavolo, tavolo};
		String[] semsotD = {tavolo, tavolo, tavolo, tavolo};
		String[] valDiag = {tavolo, tavolo, tavolo, tavolo, tavolo};
		String[] semDiag = {tavolo, tavolo, tavolo, tavolo, tavolo};
		
		*/
		switch (posRigCol[0]) {

		case 4:
			for (short j = 0; j < 5; j++) {
				if (tavGioco[posRigCol[0]][j].equals(tavolo)) {
					valRig[j] = tavolo;
					semRig[j] = tavolo;
				} else {
					valRig[j] = tavGioco[posRigCol[0]][j].substring(0,1);
					semRig[j] = tavGioco[posRigCol[0]][j].substring(1);
				}
			}
			
			if (posRigCol[1]==0) {
				
			}

			break;

		case 3:

			break;

		case 2:

			break;
		case 1:

			break;

		case 0:

			break;

		default:
			System.out.println("This will never be printed");


		}


		return carteElim;
	}




	public static void main(String[] args) {
		System.out.print("Hello, new challenger, let's play!");
		System.out.println();


		//Creazione e shuffling "buono ma non sufficiente" di carte (nota tre posti finali in caso finisci gioco)
		String tavolo = "+";
		String[] valore = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] seme = {"H","D","C","S"};
		String[] mazzo = new String[55];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++)
				mazzo[j+(13*i)] = valore[j] + seme[i];
		}

		for (int i = 0; i < 52; i++) {
			int r = i + (int) (Math.random()*(52-i));
			String t = mazzo[r];
			mazzo[r] = mazzo[i];
			mazzo[i] = t;
		}
		for (int i = 0; i < 3; i++) {
			mazzo[52+i]= tavolo;
		}


		//Creazione tavolo da gioco (con tre carte in cima vuote)
		String[] cima = new String[3];
		for (int i = 0; i < 3; i++) {
			cima[i] = mazzo[i];
		}

		String[][] tavGioco = {
				{tavolo, tavolo, tavolo, tavolo, tavolo},
				{tavolo, tavolo, tavolo, tavolo, tavolo},
				{tavolo, tavolo, tavolo, tavolo, tavolo},
				{tavolo, tavolo, tavolo, tavolo, tavolo},
				{tavolo, tavolo, tavolo, tavolo, tavolo}
		};

		for (int i = 0; i < 3; i++) {
			System.out.print(cima[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(tavGioco[i][j] + " ");
			}
			System.out.println();
		}


		//Cuore del gioco
		int punti = 0;
		Scanner s = new Scanner(System.in);
		int carteTavolo=0;
		short carteGiocate=0;
		short[] posRigCol= {0,0};
		while (carteGiocate <= 52) {

			//Aggiungi test doppie coppie ecc; questo qui sotto diviene else if
			//Ah-ha, me ne ero reso conto ieri

			if (carteTavolo>=3) {
				short carteElim= eliminazione(tavGioco,posRigCol, tavolo);
				carteTavolo = carteTavolo-carteElim;
			} else if (carteTavolo==25) {
				System.out.println("This is the end, your table is full. GAME OVER!");
				System.out.println("Your final score is: " + punti);
				break;
			} else if (carteGiocate==52){
				System.out.println("Outstanding, you placed all the cards in your deck. GAME OVER!");
				System.out.println("Your final score is: " + punti);
				break;
			} else {
				System.out.print("Please type your next move: ");
				String mossa = s.next();
				switch (mossa) {
				case "r":
					if (cima[0].equals(tavolo) && cima[1].equals(tavolo)) {
						//--------------------------
						for (int i = 0; i < 3; i++) {
							System.out.print(cima[i] + " ");
						}
						System.out.println();
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								System.out.print(tavGioco[i][j] + " ");
							}
							System.out.println();
						}
						//--------------------------
						break;
					} else if (cima[0].equals(tavolo)) {
						String t = cima[1];
						cima[1]=cima[2];
						cima[2]=t;
						//--------------------------
						for (int i = 0; i < 3; i++) {
							System.out.print(cima[i] + " ");
						}
						System.out.println();
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								System.out.print(tavGioco[i][j] + " ");
							}
							System.out.println();
						}
						//--------------------------
						break;
					} else {
						String t = cima[2];
						cima[2]=cima[1];
						cima[1]=cima[0];
						cima[0]=t;
						//--------------------------
						for (int i = 0; i < 3; i++) {
							System.out.print(cima[i] + " ");
						}
						System.out.println();
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 5; j++) {
								System.out.print(tavGioco[i][j] + " ");
							}
							System.out.println();
						}
						//--------------------------
						break;
					}

				case "1":
					if (!tavGioco[0][0].equals(tavolo)) {
						System.out.print("Full column, try another one. ");
						break;
					} else {
						posRigCol = cuoreGD(mazzo, cima, tavGioco, mossa, tavolo, carteGiocate);
						carteTavolo++;
						carteGiocate++;
						break;
					}

				case "2":
					if (!tavGioco[0][1].equals(tavolo)) {
						System.out.print("Full column, try another one. ");
						break;
					} else {
						posRigCol = cuoreGD(mazzo, cima, tavGioco, mossa, tavolo, carteGiocate);
						carteTavolo++;
						carteGiocate++;
						break;
					}

				case "3":
					if (!tavGioco[0][2].equals(tavolo)) {
						System.out.print("Full column, try another one. ");
						break;
					} else {
						posRigCol = cuoreGD(mazzo, cima, tavGioco, mossa, tavolo, carteGiocate);
						carteTavolo++;
						carteGiocate++;
						break;
					}

				case "4":
					if (!tavGioco[0][3].equals(tavolo)) {
						System.out.print("Full column, try another one. ");
						break;
					} else {
						posRigCol = cuoreGD(mazzo, cima, tavGioco, mossa, tavolo, carteGiocate);
						carteTavolo++;
						carteGiocate++;
						break;
					}

				case "5":
					if (!tavGioco[0][4].equals(tavolo)) {
						System.out.print("Full column, try another one. ");
						break;
					} else {
						posRigCol = cuoreGD(mazzo, cima, tavGioco, mossa, tavolo, carteGiocate);
						carteTavolo++;
						carteGiocate++;
						break;
					}

				default:
					System.out.print("Move not recognised; try again! Type: ");

				}
			}
			//System.out.println(carteGiocate);
		}

		s.close();























	}
}
