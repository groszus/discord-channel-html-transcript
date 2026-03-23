package dev.omardiaa.transcript.core.util;

import dev.omardiaa.transcript.core.model.payload.Guild;
import org.jspecify.annotations.NullMarked;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * A helper class for generating icons.
 */
@NullMarked
public final class IconUtil {
  private IconUtil() {}

  /**
   * Draws an Icon of {@link Guild#name()} initials.
   *
   * @param str
   *   the sentence used to retrieve the initials from.
   *
   * @return a base64 encoded {@code image/png} of the {@link Guild#name()} initials.
   */
  public static String drawGuildIcon(String str) {
    int width = 50;
    int height = 50;

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = image.createGraphics();

    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    Color bgColor = new Color(151, 151, 159, 20);

    g2d.setColor(bgColor);
    g2d.fillRect(0, 0, width, height);

    g2d.setFont(new Font("Arial", Font.BOLD, 20));
    g2d.setColor(Color.WHITE);

    String initials = Helper.getInitials(str);
    FontMetrics fm = g2d.getFontMetrics();

    int x = (width - fm.stringWidth(initials)) / 2;
    int y = ((height - fm.getHeight()) / 2) + fm.getAscent();

    g2d.drawString(initials, x, y);

    g2d.dispose();

    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      ImageIO.write(image, "png", baos);
      return "data:image/png;base64," + Base64.getEncoder().encodeToString(baos.toByteArray());
    } catch (IOException ex) {
      return "";
    }
  }
}
