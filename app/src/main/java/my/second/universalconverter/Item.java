package my.second.universalconverter;

public class Item {
    String item_Name;
    int item_Image;

    public Item(String itemName,int itemImage)
    {
        this.item_Image=itemImage;
        this.item_Name=itemName;
    }
    public String getItemName()
    {
        return item_Name;
    }
    public int getItemImage()
    {
        return item_Image;
    }

}
