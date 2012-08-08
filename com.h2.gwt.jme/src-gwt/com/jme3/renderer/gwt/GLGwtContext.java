package com.jme3.renderer.gwt;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Collection;

import com.google.gwt.canvas.dom.client.Context;
import com.google.gwt.typedarrays.client.Float32Array;
import com.google.gwt.typedarrays.client.Int32Array;
import com.googlecode.gwtgl.binding.WebGLRenderbuffer;

public interface GLGwtContext extends Context {
    
    public static final int GL_FALSE = 0;
    
    public static final int GL_TRUE = 1;
    
    /* ClearBufferMask */
    public static final int GL_DEPTH_BUFFER_BIT               = 0x00000100;
    public static final int GL_STENCIL_BUFFER_BIT             = 0x00000400;
    public static final int GL_COLOR_BUFFER_BIT               = 0x00004000;
    
    /* BeginMode */
    public static final int GL_POINTS                         = 0x0000;
    public static final int GL_LINES                          = 0x0001;
    public static final int GL_LINE_LOOP                      = 0x0002;
    public static final int GL_LINE_STRIP                     = 0x0003;
    public static final int GL_TRIANGLES                      = 0x0004;
    public static final int GL_TRIANGLE_STRIP                 = 0x0005;
    public static final int GL_TRIANGLE_FAN                   = 0x0006;
    
    /* AlphaFunction (not supported in ES20) */
    /*      NEVER */
    /*      LESS */
    /*      EQUAL */
    /*      LEQUAL */
    /*      GREATER */
    /*      NOTEQUAL */
    /*      GEQUAL */
    /*      ALWAYS */
    
    /* BlendingFactorDest */
    public static final int GL_ZERO                           = 0;
    public static final int GL_ONE                            = 1;
    public static final int GL_SRC_COLOR                      = 0x0300;
    public static final int GL_ONE_MINUS_SRC_COLOR            = 0x0301;
    public static final int GL_SRC_ALPHA                      = 0x0302;
    public static final int GL_ONE_MINUS_SRC_ALPHA            = 0x0303;
    public static final int GL_DST_ALPHA                      = 0x0304;
    public static final int GL_ONE_MINUS_DST_ALPHA            = 0x0305;
    
    /* BlendingFactorSrc */
    /*      ZERO */
    /*      ONE */
    public static final int GL_DST_COLOR                      = 0x0306;
    public static final int GL_ONE_MINUS_DST_COLOR            = 0x0307;
    public static final int GL_SRC_ALPHA_SATURATE             = 0x0308;
    /*      SRC_ALPHA */
    /*      ONE_MINUS_SRC_ALPHA */
    /*      DST_ALPHA */
    /*      ONE_MINUS_DST_ALPHA */
    
    /* BlendEquationSeparate */
    public static final int GL_FUNC_ADD                       = 0x8006;
    public static final int GL_BLEND_EQUATION                 = 0x8009;
    public static final int GL_BLEND_EQUATION_RGB             = 0x8009;   /* same as BLEND_EQUATION */
    public static final int GL_BLEND_EQUATION_ALPHA           = 0x883D;
    
    /* BlendSubtract */
    public static final int GL_FUNC_SUBTRACT                  = 0x800A;
    public static final int GL_FUNC_REVERSE_SUBTRACT          = 0x800B;
    
    /* Separate Blend Functions */
    public static final int GL_BLEND_DST_RGB                  = 0x80C8;
    public static final int GL_BLEND_SRC_RGB                  = 0x80C9;
    public static final int GL_BLEND_DST_ALPHA                = 0x80CA;
    public static final int GL_BLEND_SRC_ALPHA                = 0x80CB;
    public static final int GL_CONSTANT_COLOR                 = 0x8001;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR       = 0x8002;
    public static final int GL_CONSTANT_ALPHA                 = 0x8003;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA       = 0x8004;
    public static final int GL_BLEND_COLOR                    = 0x8005;
    
    /* Buffer Objects */
    public static final int GL_ARRAY_BUFFER                   = 0x8892;
    public static final int GL_ELEMENT_ARRAY_BUFFER           = 0x8893;
    public static final int GL_ARRAY_BUFFER_BINDING           = 0x8894;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING   = 0x8895;
    
    public static final int GL_STREAM_DRAW                    = 0x88E0;
    public static final int GL_STATIC_DRAW                    = 0x88E4;
    public static final int GL_DYNAMIC_DRAW                   = 0x88E8;
    
    public static final int BUFFER_SIZE                    = 0x8764;
    public static final int BUFFER_USAGE                   = 0x8765;
    
    public static final int CURRENT_VERTEX_ATTRIB          = 0x8626;
    
    /* CullFaceMode */
    public static final int GL_FRONT                          = 0x0404;
    public static final int GL_BACK                           = 0x0405;
    public static final int GL_FRONT_AND_BACK                 = 0x0408;
    
    /* DepthFunction */
    /*      NEVER */
    /*      LESS */
    /*      EQUAL */
    /*      LEQUAL */
    /*      GREATER */
    /*      NOTEQUAL */
    /*      GEQUAL */
    /*      ALWAYS */
    
    /* EnableCap */
    /* TEXTURE_2D */
    public static final int GL_CULL_FACE                      = 0x0B44;
    public static final int GL_BLEND                          = 0x0BE2;
    public static final int GL_DITHER                         = 0x0BD0;
    public static final int GL_STENCIL_TEST                   = 0x0B90;
    public static final int GL_DEPTH_TEST                     = 0x0B71;
    public static final int GL_SCISSOR_TEST                   = 0x0C11;
    public static final int GL_POLYGON_OFFSET_FILL            = 0x8037;
    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE       = 0x809E;
    public static final int GL_SAMPLE_COVERAGE                = 0x80A0;
    
    /* ErrorCode */
    public static final int GL_NO_ERROR                       = 0;
    public static final int GL_INVALID_ENUM                   = 0x0500;
    public static final int GL_INVALID_VALUE                  = 0x0501;
    public static final int GL_INVALID_OPERATION              = 0x0502;
    public static final int GL_OUT_OF_MEMORY                  = 0x0505;
    
    /* FrontFaceDirection */
    public static final int GL_CW                             = 0x0900;
    public static final int GL_CCW                            = 0x0901;
    
    /* GetPName */
    public static final int LINE_WIDTH                     = 0x0B21;
    public static final int ALIASED_POINT_SIZE_RANGE       = 0x846D;
    public static final int ALIASED_LINE_WIDTH_RANGE       = 0x846E;
    public static final int CULL_FACE_MODE                 = 0x0B45;
    public static final int FRONT_FACE                     = 0x0B46;
    public static final int DEPTH_RANGE                    = 0x0B70;
    public static final int DEPTH_WRITEMASK                = 0x0B72;
    public static final int DEPTH_CLEAR_VALUE              = 0x0B73;
    public static final int DEPTH_FUNC                     = 0x0B74;
    public static final int STENCIL_CLEAR_VALUE            = 0x0B91;
    public static final int STENCIL_FUNC                   = 0x0B92;
    public static final int STENCIL_FAIL                   = 0x0B94;
    public static final int STENCIL_PASS_DEPTH_FAIL        = 0x0B95;
    public static final int STENCIL_PASS_DEPTH_PASS        = 0x0B96;
    public static final int STENCIL_REF                    = 0x0B97;
    public static final int STENCIL_VALUE_MASK             = 0x0B93;
    public static final int STENCIL_WRITEMASK              = 0x0B98;
    public static final int STENCIL_BACK_FUNC              = 0x8800;
    public static final int STENCIL_BACK_FAIL              = 0x8801;
    public static final int STENCIL_BACK_PASS_DEPTH_FAIL   = 0x8802;
    public static final int STENCIL_BACK_PASS_DEPTH_PASS   = 0x8803;
    public static final int STENCIL_BACK_REF               = 0x8CA3;
    public static final int STENCIL_BACK_VALUE_MASK        = 0x8CA4;
    public static final int STENCIL_BACK_WRITEMASK         = 0x8CA5;
    public static final int VIEWPORT                       = 0x0BA2;
    public static final int SCISSOR_BOX                    = 0x0C10;
    /*      SCISSOR_TEST */
    public static final int GL_COLOR_CLEAR_VALUE              = 0x0C22;
    public static final int GL_COLOR_WRITEMASK                = 0x0C23;
    public static final int GL_UNPACK_ALIGNMENT               = 0x0CF5;
    public static final int GL_PACK_ALIGNMENT                 = 0x0D05;
    public static final int GL_MAX_TEXTURE_SIZE               = 0x0D33;
    public static final int GL_MAX_VIEWPORT_DIMS              = 0x0D3A;
    public static final int GL_SUBPIXEL_BITS                  = 0x0D50;
    public static final int GL_RED_BITS                       = 0x0D52;
    public static final int GL_GREEN_BITS                     = 0x0D53;
    public static final int GL_BLUE_BITS                      = 0x0D54;
    public static final int GL_ALPHA_BITS                     = 0x0D55;
    public static final int GL_DEPTH_BITS                     = 0x0D56;
    public static final int GL_STENCIL_BITS                   = 0x0D57;
    public static final int GL_POLYGON_OFFSET_UNITS           = 0x2A00;
    /*      POLYGON_OFFSET_FILL */
    public static final int GL_POLYGON_OFFSET_FACTOR          = 0x8038;
    public static final int GL_TEXTURE_BINDING_2D             = 0x8069;
    public static final int GL_SAMPLE_BUFFERS                 = 0x80A8;
    public static final int GL_SAMPLES                        = 0x80A9;
    public static final int GL_SAMPLE_COVERAGE_VALUE          = 0x80AA;
    public static final int GL_SAMPLE_COVERAGE_INVERT         = 0x80AB;
    
    /* GetTextureParameter */
    /*      TEXTURE_MAG_FILTER */
    /*      TEXTURE_MIN_FILTER */
    /*      TEXTURE_WRAP_S */
    /*      TEXTURE_WRAP_T */
    
    public static final int COMPRESSED_TEXTURE_FORMATS     = 0x86A3;
    
    /* HintMode */
    public static final int GL_DONT_CARE                      = 0x1100;
    public static final int GL_FASTEST                        = 0x1101;
    public static final int GL_NICEST                         = 0x1102;
    
    /* HintTarget */
    public static final int GL_GENERATE_MIPMAP_HINT            = 0x8192;
    
    /* DataType */
    public static final int GL_BYTE                           = 0x1400;
    public static final int GL_UNSIGNED_BYTE                  = 0x1401;
    public static final int GL_SHORT                          = 0x1402;
    public static final int GL_UNSIGNED_SHORT                 = 0x1403;
    public static final int GL_INT                            = 0x1404;
    public static final int GL_UNSIGNED_INT                   = 0x1405;
    public static final int GL_FLOAT                          = 0x1406;
    public static final int GL_DOUBLE                         = GL_FLOAT;
    
    /* PixelFormat */
    public static final int GL_DEPTH_COMPONENT                = 0x1902;
    public static final int GL_ALPHA                          = 0x1906;
    public static final int GL_RGB                            = 0x1907;
    public static final int GL_RGBA                           = 0x1908;
    public static final int GL_LUMINANCE                      = 0x1909;
    public static final int GL_LUMINANCE_ALPHA                = 0x190A;
    
    /* PixelType */
    /*      UNSIGNED_BYTE */
    public static final int UNSIGNED_SHORT_4_4_4_4         = 0x8033;
    public static final int UNSIGNED_SHORT_5_5_5_1         = 0x8034;
    public static final int UNSIGNED_SHORT_5_6_5           = 0x8363;
    
    /* Shaders */
    public static final int GL_FRAGMENT_SHADER                  = 0x8B30;
    public static final int GL_VERTEX_SHADER                    = 0x8B31;
    public static final int GL_MAX_VERTEX_ATTRIBS               = 0x8869;
    public static final int GL_MAX_VERTEX_UNIFORM_VECTORS       = 0x8DFB;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS    =
            GL_MAX_VERTEX_UNIFORM_VECTORS;
    public static final int GL_MAX_VARYING_VECTORS              = 0x8DFC;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 0x8B4D;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS   = 0x8B4C;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS          = 0x8872;
    public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS     = 0x8DFD;
    public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS  =
            GL_MAX_FRAGMENT_UNIFORM_VECTORS;
    public static final int GL_SHADER_TYPE                      = 0x8B4F;
    public static final int GL_DELETE_STATUS                    = 0x8B80;
    public static final int GL_LINK_STATUS                      = 0x8B82;
    public static final int GL_VALIDATE_STATUS                  = 0x8B83;
    public static final int GL_ATTACHED_SHADERS                 = 0x8B85;
    public static final int GL_ACTIVE_UNIFORMS                  = 0x8B86;
    public static final int GL_ACTIVE_ATTRIBUTES                = 0x8B89;
    public static final int GL_SHADING_LANGUAGE_VERSION         = 0x8B8C;
    public static final int GL_CURRENT_PROGRAM                  = 0x8B8D;
    
    /* StencilFunction */
    public static final int GL_NEVER                          = 0x0200;
    public static final int GL_LESS                           = 0x0201;
    public static final int GL_EQUAL                          = 0x0202;
    public static final int GL_LEQUAL                         = 0x0203;
    public static final int GL_GREATER                        = 0x0204;
    public static final int GL_NOTEQUAL                       = 0x0205;
    public static final int GL_GEQUAL                         = 0x0206;
    public static final int GL_ALWAYS                         = 0x0207;
    
    /* StencilOp */
    /*      ZERO */
    public static final int GL_KEEP                           = 0x1E00;
    public static final int GL_REPLACE                        = 0x1E01;
    public static final int GL_INCR                           = 0x1E02;
    public static final int GL_DECR                           = 0x1E03;
    public static final int GL_INVERT                         = 0x150A;
    public static final int GL_INCR_WRAP                      = 0x8507;
    public static final int GL_DECR_WRAP                      = 0x8508;
    
    /* StringName */
    public static final int GL_VENDOR                         = 0x1F00;
    public static final int GL_RENDERER                       = 0x1F01;
    public static final int GL_VERSION                        = 0x1F02;
    
    /* TextureMagFilter */
    public static final int GL_NEAREST                        = 0x2600;
    public static final int GL_LINEAR                         = 0x2601;
    
    /* TextureMinFilter */
    /*      NEAREST */
    /*      LINEAR */
    public static final int GL_NEAREST_MIPMAP_NEAREST         = 0x2700;
    public static final int GL_LINEAR_MIPMAP_NEAREST          = 0x2701;
    public static final int GL_NEAREST_MIPMAP_LINEAR          = 0x2702;
    public static final int GL_LINEAR_MIPMAP_LINEAR           = 0x2703;
    
    /* TextureParameterName */
    public static final int GL_TEXTURE_MAG_FILTER             = 0x2800;
    public static final int GL_TEXTURE_MIN_FILTER             = 0x2801;
    public static final int GL_TEXTURE_WRAP_S                 = 0x2802;
    public static final int GL_TEXTURE_WRAP_T                 = 0x2803;
    
    /* TextureTarget */
    public static final int GL_TEXTURE_2D                     = 0x0DE1;
    public static final int GL_TEXTURE                        = 0x1702;
    
    public static final int GL_TEXTURE_CUBE_MAP               = 0x8513;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP       = 0x8514;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X    = 0x8515;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X    = 0x8516;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y    = 0x8517;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y    = 0x8518;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z    = 0x8519;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z    = 0x851A;
    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE      = 0x851C;
    
    /* TextureUnit */
    public static final int GL_TEXTURE0                       = 0x84C0;
    public static final int GL_TEXTURE1                       = 0x84C1;
    public static final int GL_TEXTURE2                       = 0x84C2;
    public static final int GL_TEXTURE3                       = 0x84C3;
    public static final int GL_TEXTURE4                       = 0x84C4;
    public static final int GL_TEXTURE5                       = 0x84C5;
    public static final int GL_TEXTURE6                       = 0x84C6;
    public static final int GL_TEXTURE7                       = 0x84C7;
    public static final int GL_TEXTURE8                       = 0x84C8;
    public static final int GL_TEXTURE9                       = 0x84C9;
    public static final int GL_TEXTURE10                      = 0x84CA;
    public static final int GL_TEXTURE11                      = 0x84CB;
    public static final int GL_TEXTURE12                      = 0x84CC;
    public static final int GL_TEXTURE13                      = 0x84CD;
    public static final int GL_TEXTURE14                      = 0x84CE;
    public static final int GL_TEXTURE15                      = 0x84CF;
    public static final int GL_TEXTURE16                      = 0x84D0;
    public static final int GL_TEXTURE17                      = 0x84D1;
    public static final int GL_TEXTURE18                      = 0x84D2;
    public static final int GL_TEXTURE19                      = 0x84D3;
    public static final int GL_TEXTURE20                      = 0x84D4;
    public static final int GL_TEXTURE21                      = 0x84D5;
    public static final int GL_TEXTURE22                      = 0x84D6;
    public static final int GL_TEXTURE23                      = 0x84D7;
    public static final int GL_TEXTURE24                      = 0x84D8;
    public static final int GL_TEXTURE25                      = 0x84D9;
    public static final int GL_TEXTURE26                      = 0x84DA;
    public static final int GL_TEXTURE27                      = 0x84DB;
    public static final int GL_TEXTURE28                      = 0x84DC;
    public static final int GL_TEXTURE29                      = 0x84DD;
    public static final int GL_TEXTURE30                      = 0x84DE;
    public static final int GL_TEXTURE31                      = 0x84DF;
    public static final int ACTIVE_TEXTURE                 = 0x84E0;
    
    /* TextureWrapMode */
    public static final int GL_REPEAT                         = 0x2901;
    public static final int GL_CLAMP_TO_EDGE                  = 0x812F;
    public static final int GL_MIRRORED_REPEAT                = 0x8370;
    
    /* Uniform Types */
    public static final int FLOAT_VEC2                     = 0x8B50;
    public static final int FLOAT_VEC3                     = 0x8B51;
    public static final int FLOAT_VEC4                     = 0x8B52;
    public static final int INT_VEC2                       = 0x8B53;
    public static final int INT_VEC3                       = 0x8B54;
    public static final int INT_VEC4                       = 0x8B55;
    public static final int BOOL                           = 0x8B56;
    public static final int BOOL_VEC2                      = 0x8B57;
    public static final int BOOL_VEC3                      = 0x8B58;
    public static final int BOOL_VEC4                      = 0x8B59;
    public static final int FLOAT_MAT2                     = 0x8B5A;
    public static final int FLOAT_MAT3                     = 0x8B5B;
    public static final int FLOAT_MAT4                     = 0x8B5C;
    public static final int SAMPLER_2D                     = 0x8B5E;
    public static final int SAMPLER_CUBE                   = 0x8B60;
    
    /* Vertex Arrays */
    public static final int VERTEX_ATTRIB_ARRAY_ENABLED        = 0x8622;
    public static final int VERTEX_ATTRIB_ARRAY_SIZE           = 0x8623;
    public static final int VERTEX_ATTRIB_ARRAY_STRIDE         = 0x8624;
    public static final int VERTEX_ATTRIB_ARRAY_TYPE           = 0x8625;
    public static final int VERTEX_ATTRIB_ARRAY_NORMALIZED     = 0x886A;
    public static final int VERTEX_ATTRIB_ARRAY_POINTER        = 0x8645;
    public static final int VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 0x889F;
    
    /* Shader Source */
    public static final int GL_COMPILE_STATUS                 = 0x8B81;
    
    /* Shader Precision-Specified Types */
    public static final int LOW_FLOAT                      = 0x8DF0;
    public static final int MEDIUM_FLOAT                   = 0x8DF1;
    public static final int HIGH_FLOAT                     = 0x8DF2;
    public static final int LOW_INT                        = 0x8DF3;
    public static final int MEDIUM_INT                     = 0x8DF4;
    public static final int HIGH_INT                       = 0x8DF5;
    
    /* Framebuffer Object. */
    public static final int GL_FRAMEBUFFER                    = 0x8D40;
    public static final int GL_RENDERBUFFER                   = 0x8D41;
    public static final int GL_RENDERBUFFER_EXT                   = GL_RENDERBUFFER;
    
    public static final int GL_DRAW_BUFFER                    = GL_FRAMEBUFFER;
    public static final int GL_READ_BUFFER                    = GL_RENDERBUFFER;
    
    public static final int GL_RGBA4                          = 0x8056;
    public static final int GL_RGB5_A1                        = 0x8057;
    public static final int GL_RGB565                         = 0x8D62;
    public static final int GL_DEPTH_COMPONENT16              = 0x81A5;
    public static final int GL_STENCIL_INDEX                  = 0x1901;
    public static final int GL_STENCIL_INDEX8                 = 0x8D48;
    public static final int GL_DEPTH_STENCIL                  = 0x84F9;
    
    public static final int GL_RENDERBUFFER_WIDTH             = 0x8D42;
    public static final int GL_RENDERBUFFER_HEIGHT            = 0x8D43;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT   = 0x8D44;
    public static final int GL_RENDERBUFFER_RED_SIZE          = 0x8D50;
    public static final int GL_RENDERBUFFER_GREEN_SIZE        = 0x8D51;
    public static final int GL_RENDERBUFFER_BLUE_SIZE         = 0x8D52;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE        = 0x8D53;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE        = 0x8D54;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE      = 0x8D55;
    
    public static final int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE           = 0x8CD0;
    public static final int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME           = 0x8CD1;
    public static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL         = 0x8CD2;
    public static final int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;
    
    public static final int GL_COLOR_ATTACHMENT0              = 0x8CE0;
    public static final int GL_COLOR_ATTACHMENT0_EXT              = GL_COLOR_ATTACHMENT0;
    public static final int GL_DEPTH_ATTACHMENT               = 0x8D00;
    public static final int GL_DEPTH_ATTACHMENT_EXT               = GL_DEPTH_ATTACHMENT;
    public static final int GL_STENCIL_ATTACHMENT             = 0x8D20;
    public static final int GL_DEPTH_STENCIL_ATTACHMENT       = 0x821A;
    
    public static final int GL_NONE                           = 0;
    
    public static final int FRAMEBUFFER_COMPLETE                      = 0x8CD5;
    public static final int FRAMEBUFFER_INCOMPLETE_ATTACHMENT         = 0x8CD6;
    public static final int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8CD7;
    public static final int FRAMEBUFFER_INCOMPLETE_DIMENSIONS         = 0x8CD9;
    public static final int FRAMEBUFFER_UNSUPPORTED                   = 0x8CDD;
    
    public static final int FRAMEBUFFER_BINDING            = 0x8CA6;
    public static final int RENDERBUFFER_BINDING           = 0x8CA7;
    public static final int GL_MAX_RENDERBUFFER_SIZE          = 0x84E8;
    
    public static final int INVALID_FRAMEBUFFER_OPERATION  = 0x0506;
    
    /* WebGL-specific enums */
    public static final int UNPACK_FLIP_Y_WEBGL            = 0x9240;
    public static final int UNPACK_PREMULTIPLY_ALPHA_WEBGL = 0x9241;
    public static final int CONTEXT_LOST_WEBGL             = 0x9242;
    public static final int UNPACK_COLORSPACE_CONVERSION_WEBGL = 0x9243;
    public static final int BROWSER_DEFAULT_WEBGL          = 0x9244;
    
    
    public static final int GL_DOUBLEBUFFER          = 0x9900;
    public static final int GL_FRAMEBUFFER_EXT       = 0x9901;
    public static final int GL_READ_FRAMEBUFFER_EXT  = 0x9902;
    public static final int GL_DRAW_FRAMEBUFFER_EXT  = 0x9903;
    
    /* Removed enums */
    public static final int GL_INFO_LOG_LENGTH = -1;
    

      public void glActiveTexture(int texture);
      
      public void glAttachShader(int program, int shader);
      
      public void glAlphaFunc(int i, float j);

      public void glBegin(int mode);
      
      public void glBindAttribLocation(int program, int index, ByteBuffer name);
      
      public void glBlendColor(float red, float green, float blue, float alpha);
      
      public void glBlendEquation(int mode);

      public void glBindTexture(int glTexture2d, int texnum);
      
      public void glBlendEquationSeparate(int modeRGB, int modeAlpha);

      public void glBlendFunc(int glOne, int glOne2);

      public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);
      
      public void glBufferData(int target, Buffer data, int usage);
      
      public void glBufferData(int target, float size, int usage);
      
      public void glBufferSubData(int target, int offset, Buffer data);

      public void glClear(int bits);

      public void glClearColor(float r, float g, float b, float a);
      
      public void glClearDepth(float depth);
      
      public void glClearStencil(int s);

      public void glClientActiveTexture(int texture);

      public void glColor3f(float r, float g, float b);

      public void glColor3ub(byte r, byte g, byte b);

      public void glColor4f(float r, float g, float b, float a);

      public void glColor4ub(byte r, byte g, byte b, byte a);
      
      public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha);

      public void glColorPointer(int i, boolean b, int j,
          ByteBuffer colorAsByteBuffer);

      public void glColorPointer(int size, int j, FloatBuffer colorArrayBuf);
      
      public void glCopyTexImage2D(int target, int level, int intformat, int x, int y, int width,
              int height, int border);
      
      public void glCopyTexSubImage2D(int target, int level, int intformat, int xoffset,
              int yoffset, int x, int y, int width, int height);

      public void glCullFace(int face);
      
      public void glDeleteShader(int shader);

      public void glDeleteTextures(IntBuffer texnumBuffer);

      public void glDepthFunc(int func);

      public void glDepthMask(boolean b);

      public void glDepthRange(float gldepthmin, float gldepthmax);

      public void glDisable(int name);

      public void glDisableClientState(int state);
      
      public void glDisableVertexAttribArray(int index);

      public void glDrawArrays(int mode, int first, int count);

      public void glDrawBuffer(int buf);
      
      public void glDrawBuffers(IntBuffer buf);

      public void glDrawElements(int mode, ShortBuffer srcIndexBuf);

      public void glEnable(int name);

      public void glEnableClientState(int state);
      
      public void glEnableVertexAttribArray(int index);

      public void glEnd();

      public void glFinish();

      public void glFrustum(double left, double right, double bottom, double top,
          double znear, double zfar);

      public int glGetError();

      public void glGetFloat(int name, FloatBuffer result);
      
      public int glGetInteger(int pname);

      public void glGetInteger(int pname, IntBuffer params);

      public String glGetString(int glVendor);
      
      public void glGetShader(int shader, int status, Buffer buffer);
      
      public String glGetShaderSource(int shader, IntBuffer length, ByteBuffer source);

      public void glLoadIdentity();

      public void glLoadMatrix(FloatBuffer m);

      public void glMatrixMode(int mm);

      public void glMultMatrixf(float[] matrix, int ofs);

      public void glOrtho(int left, int right, int bottom, int top, int near,
          int far);
      
      public void glReadBuffer(int buf);
      
      public void glReadBuffers(IntBuffer buf);

      public void glPixelStorei(int i, int j);

      public void glPointParameterf(int id, float value);

      public void glPointSize(float value);

      public void glPolygonMode(int i, int j);
      
      public void glPolygonOffset(float factor, float units);

      public void glPopMatrix();

      public void glPushMatrix();

      public void glReadPixels(int x, int y, int width, int height,
          int glBgr, int glUnsignedByte, ByteBuffer image);

      public void glRotatef(float angle, float x, float y, float z);

      public void glScalef(float x, float y, float z);

      public void glScissor(int x, int i, int width, int height);

      public void glShadeModel(int sm);
      
      public void glStencilFunc(int func, int ref, int mask);
      
      public void glStencilFuncSeparate(int face, int func, int ref, int mask);
      
      public void glStencilMask(int mask);
      
      public void glStencilOp(int fail, int zfail, int zpass);
      
      public void glStencilOpSeparate(int face, int fail, int zfail, int zpass);

      public void glTexCoord2f(float x, float y);
      

      public void glTexCoordPointer(int size, int byteStride,
          FloatBuffer buf);

      public void glTexEnvi(int glTextureEnv, int glTextureEnvMode,
          int mode);

      public void glTexImage2D(int target, int level, int internalformat,
          int width, int height, int border, int format, int type, ByteBuffer pixels);

      public void glTexImage2D(int target, int level, int internalformat,
          int width, int height, int border, int format, int type, IntBuffer pixels);

      public void glTexParameterf(int target, int pname, float param);

      public void glTexParameteri(int glTexture2d, int glTextureMinFilter,
          int glFilterMin);

      public void glTexSubImage2D(int target, int level, int xoffset,
          int yoffset, int width, int height, int format, int type,
          ByteBuffer pixels);

      public void glTexSubImage2D(int target, int level, int xoffset,
          int yoffset, int width, int height, int format, int type, IntBuffer pixels);

      public void glTranslatef(float tx, float ty, float tz);

      public void glVertex2f(int x, int y);

      public void glVertex3f(float x, float y, float z);
      
      public void glVertexAttribPointer(int bufIndex, int size, int type,
              boolean normalize, int byteStride, int byteOffset);

      public void glVertexAttribPointer(int bufIndex, int size, int type,
          boolean normalize, int byteStride, int byteOffset, Buffer nioBuffer,
          int staticDrawId);

      public void glVertexPointer(int size, int byteStride, FloatBuffer buf);

      public void glViewport(int x, int y, int w, int h);

      public boolean project(float objX, float objY, float objZ, int[] view,
          float[] win);

      public void swapBuffers();
      
      ////
      ////
      
      public int glCreateProgram();
      
//      public void glDetachShader(WebGLProgram program, WebGLShader shader);
      
      public int createBuffer();
      
      public int glCreateShader(int type);
      
      public void glGenBuffers(IntBuffer buffer);
      
//      public void glBindBuffer(int target, WebGLBuffer buffer);
      
      public void glBindBuffer(int target, int bufferId);
      
//      public void glCompileShader(WebGLShader shader);
      
      public void glDeleteBuffers(IntBuffer buffer);
      
      public void glCompileShader(int shaderId);
      
//      public WebGLProgram glCreateProgram();
      
      public void glGetProgram(int programId, int status, Buffer buffer);
      
//      public void glLinkProgram(WebGLProgram program);
      
      public void glGetProgramInfoLog(int shaderId, Object object, Buffer logBuf);
      
      public long glGetFramebufferAttachmentParameter(int target, int attachment, int pname);
      
      public int glGetUniformLocation(int id, Buffer buffer);
      
//      public void glUseProgram(WebGLProgram program);
      
      public void glUseProgram(int programId);
      
      public void glDeleteProgram(int programId);
      
      public void glUniform1(int location, FloatBuffer v);
      public void glUniform1f(int location, float x);
      public void glUniform1fv(int location, Float32Array v);
      public void glUniform1fv(int location, Collection<Float> v);
      public void glUniform1i(int location, int x);
      public void glUniform1iv(int location, Int32Array v);
      public void glUniform1iv(int location, Collection<Float> v);
      public void glUniform2(int location, FloatBuffer v);
      public void glUniform2f(int location, float x, float y);
      public void glUniform2fv(int location, Float32Array v);
      public void glUniform2fv(int location, Collection<Float> v);
      public void glUniform2i(int location, int x, int y);
      public void glUniform2iv(int location, Int32Array v);
      public void glUniform2iv(int location, Collection<Long> v);
      public void glUniform3(int location, FloatBuffer v);
      public void glUniform3f(int location, float x, float y, float z);
      public void glUniform3fv(int location, Float32Array v);
      public void glUniform3fv(int location, Collection<Float> v);
      public void glUniform3i(int location, int x, int y, int z);
      public void glUniform3iv(int location, Int32Array v);
      public void glUniform3iv(int location, Collection<Long> v);
      public void glUniform4(int location, FloatBuffer v);
      public void glUniform4f(int location, float x, float y, float z, float w);
      public void glUniform4fv(int location, Float32Array v);
      public void glUniform4fv(int location, Collection<Float> v);
      public void glUniform4i(int location, int x, int y, int z, int w);
      public void glUniform4iv(int location, Int32Array v);
      public void glUniform4iv(int location, Collection<Long> v);

      public void glUniformMatrix2fv(int location, boolean transpose, 
                            Float32Array value);
      public void glUniformMatrix2fv(int location, boolean transpose, 
              Collection<Float> value);
      public void glUniformMatrix3(int location, boolean transpose, 
              FloatBuffer value);
      public void glUniformMatrix3fv(int location, boolean transpose, 
                            Float32Array value);
      public void glUniformMatrix3fv(int location, boolean transpose, 
              Collection<Float> value);
      public void glUniformMatrix4(int location, boolean transpose, 
              FloatBuffer value);
      public void glUniformMatrix4fv(int location, boolean transpose, 
                            Float32Array value);
      public void glUniformMatrix4fv(int location, boolean transpose, 
              Collection<Float> value);
      
      public void glGenerateMipmap(int target);
      
      public void glGenerateMipmapEXT(int target);
      
      public void glDeleteRenderbuffer(WebGLRenderbuffer renderbuffer);
      
      public int glGetAttribLocation(int programId, Buffer buffer);

      public void glShaderSource(int shaderId, Buffer codeBuf);

      public void glGetShaderInfoLog(int shaderId, Object object, Buffer logBuf);
      
      public void glLinkProgram(int programId);
      
      public void glDetachShader(int programId, int shaderId);

      public void glGenTextures(Buffer buffer);
      
      public void glGenFramebuffers(Buffer buffer);
      
      public void glGenFramebuffersEXT(Buffer buffer);
      
      public void glBindFramebufferEXT(int n, int bufferId);

      public void glLineWidth(float lineWidth);

      public boolean glGetBoolean(int glDoublebuffer);

      public void glDeleteRenderbuffersEXT(Buffer buffer);

      public void glDeleteFramebuffersEXT(Buffer buffer);

      public void glDrawRangeElements(int elMode, int i, int vertCount,
            int elementLength, int fmt, int curOffset);

      public void glBlitFramebufferEXT(int i, int j, int srcW, int srcH, int k,
            int l, int dstW, int dstH, int mask, int glNearest);

      public int glCheckFramebufferStatusEXT(int glFramebufferExt);
      
      public void glFramebufferRenderbuffer(int target, int attachment,
              int renderBufferTarget, int renderBuffer);
      
      public void glFramebufferRenderbufferEXT(int target, int attachment,
              int renderBufferTarget, int renderBuffer);

      public void glFramebufferTexture2DEXT(int target,
            int attachment, int renderbuffertarget, int texture,
            int renderBuffer);
      
}
