import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class SwordObject
	{
		protected Vector pos;
		protected BufferedImage image;
		protected ArrayList<BufferedImage> anim;
		protected String type;
		protected int maxFrames;
		protected int currFrame;
		
		public SwordObject(Vector v, String t)
		{
			currFrame = 0;
			pos = v;
			type = t;
			image = null;
			loadInformation();
			
		}
		
		public Vector getPos()
		{
			return pos;
		}
		public void setPos(Vector v)
		{
			pos = v;
		}
		public BufferedImage getImage()
		{
			return image;
		}
		public void setImage(BufferedImage image)
		{
			this.image = image;
		}
		public ArrayList<BufferedImage> getAnim()
		{
			return anim;
		}
		public void setAnim(ArrayList<BufferedImage> anim)
		{
			this.anim = anim;
		}
		public ArrayList<BufferedImage> fillAnim(int size)
		{
			ArrayList<BufferedImage> newAnim = new ArrayList<BufferedImage>();
			int frameNum = 0;
			for(int j = 0; j < image.getHeight(); j+=(40 * size))
				{
					for(int k = 0; k < image.getWidth(); k+=(40 * size))
						{
							if(frameNum <= maxFrames)
								{
									newAnim.add(image.getSubimage(k, j, (40 * size), (40 * size)));
									frameNum++;
								}
						}
				}
			return newAnim;
		}
		public void loadInformation()
			{
				try
					{
						switch(type)
						{
							case "life":
								image = ImageIO.read(new File("src/Images/heart.png"));
								break;
							case "death":
								image = ImageIO.read(new File("src/Images/lostLife.png"));
								break;
							case "bossLife":
								image = ImageIO.read(new File("src/Images/bosshearts.png"));
								break;
							case "grass":
								image = ImageIO.read(new File("src/Images/grassblock2.png"));
								break;
							case "dirt":
								image = ImageIO.read(new File("src/Images/dirtblock.png"));
								break;
							case "stone":
								image = ImageIO.read(new File("src/Images/stonebrick.png"));
								break;
							case "cloud":
								image = ImageIO.read(new File("src/Images/cloud.png"));
								break;
							case "end":
								image = ImageIO.read(new File("src/Images/curtains.png"));
								break;
							case "enemy":
								image = ImageIO.read(new File("src/Images/slime.png"));
								maxFrames = 3;
								anim = fillAnim(1);
								break;
							case "player":
								image = ImageIO.read(new File("src/Images/swordsprites.png"));
								maxFrames = 4;
								anim = fillAnim(1);
								break;
							case "boss":
								image = ImageIO.read(new File("src/Images/Boss.png"));
								maxFrames = 3;
								anim = fillAnim(2);
								break;
							case "spike":
								image = ImageIO.read(new File("src/Images/spikey.png"));
								maxFrames = 3;
								anim = fillAnim(1);
								break;
							case "coin":
								image = ImageIO.read(new File("src/Images/coin.png"));
								break;
							case "lava":
								image = ImageIO.read(new File("src/Images/lava.png"));
								maxFrames = 6;
								anim = fillAnim(1);
								break;
						}
					} catch (IOException e)
					{
						e.printStackTrace();
					}
			}

		public String getType()
			{
				return type;
			}

		public void setType(String type)
			{
				this.type = type;
			}

		public int getMaxFrames()
			{
				return maxFrames;
			}

		public void setMaxFrames(int maxFrames)
			{
				this.maxFrames = maxFrames;
			}

		public int getCurrFrame()
			{
				return currFrame;
			}

		public void setCurrFrame(int currFrame)
			{
				this.currFrame = currFrame;
			}
		
		
		
	}
