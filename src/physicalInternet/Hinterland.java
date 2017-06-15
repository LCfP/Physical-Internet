package physicalInternet;

import java.util.ArrayList;

public class Hinterland {

	public int x;
	public int y;
	public int id;

	private ArrayList<Region> regions = new ArrayList<Region>();

	public Hinterland(int id, int x, int y) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public Region addRegion(int id, int x, int y) {
		Region region = new Region(id, x, y);
		regions.add(region);
		return region;

	}

	public Region getRegion(int id) {
		for (Region region : regions) {
			if (region.id == id) {
				return region;

			}
		}
		return null;
	}
}
