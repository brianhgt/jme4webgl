package com.jme3.renderer.gwt;

import com.jme3.renderer.RendererException;
import com.jme3.texture.Image.Format;

import static com.jme3.renderer.gwt.GLGwtContext.*;

public class TextureUtil {
    
static class GLImageFormat {
        
        int internalFormat;
        int format;
        int dataType;
        boolean compressed;

        public GLImageFormat(int internalFormat, int format, int dataType, boolean compressed) {
            this.internalFormat = internalFormat;
            this.format = format;
            this.dataType = dataType;
            this.compressed = compressed;
        }
    }
    
    private static final GLImageFormat[] formatToGL = new GLImageFormat[Format.values().length];
    
    private static void setFormat(Format format, int glInternalFormat, int glFormat, int glDataType, boolean glCompressed){
        formatToGL[format.ordinal()] = new GLImageFormat(glInternalFormat, glFormat, glDataType, glCompressed);
    }
    
    static {
        // Alpha formats
        setFormat(Format.Alpha8,  GL_ALPHA,  GL_ALPHA, GL_UNSIGNED_BYTE, false);
        setFormat(Format.Alpha16, GL_ALPHA, GL_ALPHA, GL_UNSIGNED_BYTE, false);
        
        // Luminance formats
        setFormat(Format.Luminance8,   GL_LUMINANCE,  GL_LUMINANCE, GL_UNSIGNED_BYTE, false);
        setFormat(Format.Luminance16,  GL_LUMINANCE, GL_LUMINANCE, GL_UNSIGNED_BYTE, false);
//        setFormat(Format.Luminance16F, ARBTextureFloat.GL_LUMINANCE16F_ARB, GL11.GL_LUMINANCE, GL11.GL_UNSIGNED_BYTE, false);
//        setFormat(Format.Luminance32F, ARBTextureFloat.GL_LUMINANCE32F_ARB, GL11.GL_LUMINANCE, GL11.GL_UNSIGNED_BYTE, false);
        
        // Luminance alpha formats
        setFormat(Format.Luminance8Alpha8, GL_LUMINANCE_ALPHA,  GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, false);
        setFormat(Format.Luminance16Alpha16, GL_LUMINANCE_ALPHA, GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, false);
        setFormat(Format.Luminance16FAlpha16F, GL_LUMINANCE_ALPHA, GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, false);
        
        // Depth formats
        setFormat(Format.Depth,    GL_DEPTH_COMPONENT,    GL_DEPTH_COMPONENT, GL_UNSIGNED_BYTE, false);
//        setFormat(Format.Depth16,  GL14.GL_DEPTH_COMPONENT16,  GL11.GL_DEPTH_COMPONENT, GL11.GL_UNSIGNED_BYTE, false);
//        setFormat(Format.Depth24,  GL14.GL_DEPTH_COMPONENT24,  GL11.GL_DEPTH_COMPONENT, GL11.GL_UNSIGNED_BYTE, false);
//        setFormat(Format.Depth32,  GL14.GL_DEPTH_COMPONENT32,  GL11.GL_DEPTH_COMPONENT, GL11.GL_UNSIGNED_BYTE, false);
//        setFormat(Format.Depth32F, GL30.GL_DEPTH_COMPONENT32F, GL11.GL_DEPTH_COMPONENT, GL11.GL_FLOAT,         false);
        
        // Depth stencil formats
//        setFormat(Format.Depth24Stencil8, GL30.GL_DEPTH24_STENCIL8, GL30.GL_DEPTH_STENCIL, GL30.GL_UNSIGNED_INT_24_8, false);
        
        // RGB formats
//        setFormat(Format.BGR8,       GL_RGB,  GL_BGR_EXT, GL11.GL_UNSIGNED_BYTE, false);
        setFormat(Format.RGB8,       GL_RGB,  GL_RGB,        GL_UNSIGNED_BYTE, false);
//        setFormat(Format.RGB10,      GL11.GL_RGB10, GL11.GL_RGB,        GL12.GL_UNSIGNED_INT_10_10_10_2, false); 
//        setFormat(Format.RGB16,      GL11.GL_RGB16, GL11.GL_RGB,        GL11.GL_UNSIGNED_BYTE, false); // might be incorrect
//        setFormat(Format.RGB16F,     ARBTextureFloat.GL_RGB16F_ARB, GL11.GL_RGB, ARBHalfFloatPixel.GL_HALF_FLOAT_ARB, false);
//        setFormat(Format.RGB32F,     ARBTextureFloat.GL_RGB32F_ARB, GL11.GL_RGB, GL11.GL_FLOAT, false);
        
        // Special RGB formats
//        setFormat(Format.RGB111110F, EXTPackedFloat.GL_R11F_G11F_B10F_EXT,    GL11.GL_RGB, EXTPackedFloat.GL_UNSIGNED_INT_10F_11F_11F_REV_EXT, false);
//        setFormat(Format.RGB9E5,     EXTTextureSharedExponent.GL_RGB9_E5_EXT, GL11.GL_RGB, EXTTextureSharedExponent.GL_UNSIGNED_INT_5_9_9_9_REV_EXT, false);
//        setFormat(Format.RGB16F_to_RGB111110F, EXTPackedFloat.GL_R11F_G11F_B10F_EXT,    GL11.GL_RGB, ARBHalfFloatPixel.GL_HALF_FLOAT_ARB, false);
//        setFormat(Format.RGB16F_to_RGB111110F, EXTTextureSharedExponent.GL_RGB9_E5_EXT, GL11.GL_RGB, ARBHalfFloatPixel.GL_HALF_FLOAT_ARB, false);
        
        // RGBA formats
//        setFormat(Format.ABGR8,   GL11.GL_RGBA8,       EXTAbgr.GL_ABGR_EXT, GL11.GL_UNSIGNED_BYTE, false);
//        setFormat(Format.RGB5A1,  GL11.GL_RGB5_A1,     GL11.GL_RGBA,        GL12.GL_UNSIGNED_SHORT_5_5_5_1, false);
//        setFormat(Format.RGBA8,   GL11.GL_RGBA8,       GL11.GL_RGBA,        GL11.GL_UNSIGNED_BYTE, false);
//        setFormat(Format.RGBA16,  GL11.GL_RGBA16,      GL11.GL_RGBA,        GL11.GL_UNSIGNED_BYTE, false); // might be incorrect
//        setFormat(Format.RGBA16F, ARBTextureFloat.GL_RGBA16F_ARB, GL11.GL_RGBA, ARBHalfFloatPixel.GL_HALF_FLOAT_ARB, false);
//        setFormat(Format.RGBA32F, ARBTextureFloat.GL_RGBA32F_ARB, GL11.GL_RGBA, GL11.GL_FLOAT, false);
        
        // DXT formats
//        setFormat(Format.DXT1,  EXTTextureCompressionS3TC.GL_COMPRESSED_RGB_S3TC_DXT1_EXT, GL11.GL_RGB,   GL11.GL_UNSIGNED_BYTE, true);
//        setFormat(Format.DXT1A, EXTTextureCompressionS3TC.GL_COMPRESSED_RGBA_S3TC_DXT1_EXT, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, true);
//        setFormat(Format.DXT3,  EXTTextureCompressionS3TC.GL_COMPRESSED_RGBA_S3TC_DXT3_EXT, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, true);
//        setFormat(Format.DXT5,  EXTTextureCompressionS3TC.GL_COMPRESSED_RGBA_S3TC_DXT5_EXT, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, true);
    
        // LTC/LATC/3Dc formats
//        setFormat(Format.LTC,  EXTTextureCompressionLATC.GL_COMPRESSED_LUMINANCE_LATC1_EXT,       GL11.GL_LUMINANCE,       GL11.GL_UNSIGNED_BYTE, true);
//        setFormat(Format.LATC, EXTTextureCompressionLATC.GL_COMPRESSED_LUMINANCE_ALPHA_LATC2_EXT, GL11.GL_LUMINANCE_ALPHA, GL11.GL_UNSIGNED_BYTE, true);
    }
    
    public static GLImageFormat getImageFormat(ContextCapabilities caps, Format fmt){
        switch (fmt){
            case ABGR8:
                if (!caps.GL_EXT_abgr){
                    return null;
                }
                break;
            case BGR8:
                if (!caps.OpenGL12 && !caps.GL_EXT_bgra){
                    return null;
                }
                break;
            case DXT1:
            case DXT1A:
            case DXT3:
            case DXT5:
                if (!caps.GL_EXT_texture_compression_s3tc) {
                    return null;
                }
                break;
            case Depth:
            case Depth16:
            case Depth24:
            case Depth32:
                if (!caps.OpenGL14 && !caps.GL_ARB_depth_texture){
                    return null;
                }
                break;
            case Depth24Stencil8:
                if (!caps.OpenGL30){
                    return null;
                }
                break;
            case Luminance16F:
            case Luminance16FAlpha16F:
            case Luminance32F:
                if (!caps.GL_ARB_texture_float){
                    return null;
                }
                break;
            case RGB16F:
            case RGB32F:
            case RGBA16F:
            case RGBA32F:
                if (!caps.OpenGL30 && !caps.GL_ARB_texture_float){
                    return null;
                }
                break;
            case Depth32F:
                if (!caps.OpenGL30 && !caps.GL_NV_depth_buffer_float){
                    return null;
                }
                break;
            case LATC:
            case LTC:
                if (!caps.GL_EXT_texture_compression_latc){
                    return null;
                }
                break;
            case RGB9E5:
            case RGB16F_to_RGB9E5:
                if (!caps.OpenGL30 && !caps.GL_EXT_texture_shared_exponent){
                    return null;
                }
                break;
            case RGB111110F:
            case RGB16F_to_RGB111110F:
                if (!caps.OpenGL30 && !caps.GL_EXT_packed_float){
                    return null;
                }
                break;
        }
        return formatToGL[fmt.ordinal()];
    }
    
    public static GLImageFormat getImageFormatWithError(Format fmt) {
        GLImageFormat glFmt = getImageFormat(GLContext.getCapabilities(), fmt);
        if (glFmt == null) {
            throw new RendererException("Image format '" + fmt + "' is unsupported by the video hardware.");
        }
        return glFmt;
    }

}
