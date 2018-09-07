package net.vectorpublish.desktop.vp.image.history.data;

import java.awt.image.BufferedImage;
import java.util.List;

import net.vectorpublish.desktop.vp.api.history.ReadOnlyHistoryStepDataBean;
import net.vectorpublish.desktop.vp.api.vpd.DocumentNode;
import net.vectorpublish.desktop.vp.image.history.AllowImageNode;
import net.vectorpublish.desktop.vp.utils.SetUtils;

public class AddImageData implements ReadOnlyHistoryStepDataBean {
	private static final long serialVersionUID = -1944173850898735127L;

	private final List<Integer> pathToParent;

	private final BufferedImage image;

	public AddImageData(DocumentNode node, BufferedImage image) {
		this.image = image;
		pathToParent = SetUtils.nodeToImmutableIndex(node);
	}

	public AddImageData(AllowImageNode node, BufferedImage image) {
		this.image = image;
		pathToParent = SetUtils.nodeToImmutableIndex(node);
	}

	public List<Integer> getPathToParent() {
		return pathToParent;
	}

	public BufferedImage getImage() {
		return image;
	}
}
