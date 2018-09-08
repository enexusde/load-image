package net.vectorpublish.desktop.vp.image.layer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.vectorpublish.desktop.vp.api.vpd.DocumentNode;
import net.vectorpublish.desktop.vp.api.vpd.ModificationContext;
import net.vectorpublish.desktop.vp.api.vpd.ModificationContext.LayerNodeImpl;
import net.vectorpublish.desktop.vp.image.Rect;
import net.vectorpublish.desktop.vp.image.participant.ImageDrawParticipant;

public class ImageLayer extends LayerNodeImpl {

	private final ImageDrawParticipant participant;

	public ImageLayer(ModificationContext mc, DocumentNode parent, BufferedImage image) {
		mc.super(parent);
		participant = new ImageDrawParticipant(image, this);
	}

	public ImageLayer(ModificationContext mc, LayerNodeImpl parent, BufferedImage image) {
		mc.super(parent);
		participant = new ImageDrawParticipant(image, this);
	}

	public ImageDrawParticipant getParticipant() {
		return participant;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	public BufferedImage cut(Rect rect) {
		BufferedImage completeImage = participant.getCompleteImage();
		BufferedImage result = new BufferedImage(rect.getWidth(), rect.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = result.getGraphics();
		graphics.drawImage(completeImage, 0, 0, rect.getWidth(), rect.getHeight(), rect.getX(), rect.getY(),
				rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight(), null);
		return result;
	}

}
