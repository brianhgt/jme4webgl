package com.jme3.renderer.gwt;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.typedarrays.client.Float32Array;
import com.google.gwt.typedarrays.client.Int32Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLFramebuffer;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderbuffer;
import com.googlecode.gwtgl.binding.WebGLShader;
import com.googlecode.gwtgl.binding.WebGLTexture;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;
import com.googlecode.gwtquake.client.ArrayUtils;

public class GLGwtContextImpl extends JavaScriptObject implements GLGwtContext {
    
    /** Used for logging */
    private static final Logger LOG = LoggerFactory
            .getLogger(GLGwtContextImpl.class);
    
    ////
    
    private static final List<WebGLProgram> _programs = new ArrayList<WebGLProgram>();
    
    private static final List<WebGLBuffer> _buffers = new ArrayList<WebGLBuffer>();
    
    private static final List<WebGLFramebuffer> _frameBuffers = new ArrayList<WebGLFramebuffer>();
    
    private static final List<WebGLRenderbuffer> _renderBuffers = new ArrayList<WebGLRenderbuffer>();
    
    private static final List<WebGLUniformLocation> _locations = new ArrayList<WebGLUniformLocation>();
    
    private static final List<WebGLTexture> _textures = new ArrayList<WebGLTexture>();
    
    private static final List<WebGLShader> _shaders = new ArrayList<WebGLShader>();
    
    ////
    ////
    
    protected GLGwtContextImpl() {
//        setPrograms(new ArrayList<WebGLProgram>());
//        setBuffers(new ArrayList<WebGLBuffer>());
//        setFrameBuffers(new ArrayList<WebGLFramebuffer>());
//        setRenderBuffers(new ArrayList<WebGLRenderbuffer>());
//        setLocations(new ArrayList<WebGLUniformLocation>());
//        setTextures(new ArrayList<WebGLTexture>());
//        setShaders(new ArrayList<WebGLShader>());
    }

    @Override
    public final native void glActiveTexture(int texture) /*-{
        this.activeTexture(texture);
    }-*/;

    @Override
    public final void glAttachShader(int program, int shader) {
        // TODO Auto-generated method stub
        LOG.debug("glAttachShader");
    }

    @Override
    public final void glAlphaFunc(int i, float j) {
        // TODO Auto-generated method stub
        LOG.debug("glAlphaFunc");
    }

    @Override
    public final native void glBegin(int mode) /*-{
       //not implemented
       LOG.debug("glBegin");
    }-*/;

    @Override
    public final native void glBindAttribLocation(int programId, int index, ByteBuffer name) /*-{
       this.bindAttribLocation(@com.jme3.renderer.gwt.GLGwtContextImpl::_programs.get(programId),
           index, name);
    }-*/;

    @Override
    public final native void glBlendColor(float red, float green, float blue,
            float alpha) /*-{
       this.blendColor(red, green, blue, alpha);
    }-*/;

    @Override
    public final native void glBlendEquation(int mode) /*-{
       this.blendEquation(mode);
    }-*/;

    @Override
    public final native void glBindTexture(int target, int texture) /*-{
       this.bindTexture(target, @com.jme3.renderer.gwt.GLGwtContextImpl::_textures.get(texture));
    }-*/;

    @Override
    public final native void glBlendEquationSeparate(int modeRGB, int modeAlpha) /*-{
       this.blendEquation(modeRGB, modeAlpha);
    }-*/;

    @Override
    public final native void glBlendFunc(int sfactor, int dfactor) /*-{
       this.blendFunc(sfactor, dfactor);
    }-*/;

    @Override
    public final native void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha,
            int dstAlpha) /*-{
       this.blendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
    }-*/;

    @Override
    public final native void glBufferData(int target, Buffer data, int usage) /*-{
       this.bufferData(target, data, usage);
    }-*/;

    @Override
    public final native void glBufferData(int target, float size, int usage) /*-{
       this.bufferData(target, size, usage);
    }-*/;

    @Override
    public final native void glBufferSubData(int target, int offset, Buffer data) /*-{
       this.bufferSubData(target, offset, data);
    }-*/;

    @Override
    public final native void glClear(int mask) /*-{
       this.clear(mask);
    }-*/;

    @Override
    public final native void glClearColor(float red, float green, float blue,
            float alpha) /*-{
       this.clearColor(red, green, blue, alpha);
    }-*/;

    @Override
    public final native void glClearDepth(float depth) /*-{
       this.clearDepth(depth);
    }-*/;

    @Override
    public final native void glClearStencil(int s) /*-{
       this.clearStencil(s);
    }-*/;

    @Override
    public final void glClientActiveTexture(int texture) {
       //not implemented
        LOG.debug("glClientActiveTexture");
    }

    @Override
    public final void glColor3f(float r, float g, float b) {
       //not implemented
        LOG.debug("glColor3f");
    }

    @Override
    public final void glColor3ub(byte r, byte g, byte b) {
       //not implemented
        LOG.debug("glColor3ub");
    }

    @Override
    public final void glColor4f(float r, float g, float b, float a) {
       //not implemented
        LOG.debug("glColor4f");
    }

    @Override
    public final void glColor4ub(byte r, byte g, byte b, byte a) {
       //not implemented
        LOG.debug("glColor4ub");
    }

    @Override
    public final native void glColorMask(boolean red, boolean green, boolean blue,
            boolean alpha) /*-{
       this.colorMask(red, green, blue, alpha);
    }-*/;

    @Override
    public final void glColorPointer(int i, boolean b, int j,
            ByteBuffer colorAsByteBuffer) {
       //not implemented
        LOG.debug("glColorPointer");
    }

    @Override
    public final void glColorPointer(int size, int j, FloatBuffer colorArrayBuf) {
       //not implemented
        LOG.debug("glColorPointer");
    }

    @Override
    public final native void glCopyTexImage2D(int target, int level, int internalformat, int x,
            int y, int width, int height, int border) /*-{
       this.copyTexImage2D(target, level, internalformat, x, y, width, height, border);
    }-*/;

    @Override
    public final native void glCopyTexSubImage2D(int target, int level, int intformat,
            int xoffset, int yoffset, int x, int y, int width, int height) /*-{
       this.copyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
    }-*/;

    @Override
    public final native void glCullFace(int mode) /*-{
       this.cullFace(mode);
    }-*/;

    @Override
    public final native void glDeleteShader(int shader) /*-{
       this.deleteShader(@com.jme3.renderer.gwt.GLGwtContextImpl::_shaders.get(shader));
    }-*/;

    @Override
    public final native void glDeleteTextures(IntBuffer texnumBuffer) /*-{
       this.deleteTexture(texture);
    }-*/;

    @Override
    public final native void glDepthFunc(int func) /*-{
       this.depthFunc(func);
    }-*/;

    @Override
    public final native void glDepthMask(boolean flag) /*-{
       this.depthMask(flag);
    }-*/;

    @Override
    public final native void glDepthRange(float zNear, float zFar) /*-{
       this.depthRange(zNear, zFar);
    }-*/;

    @Override
    public final native void glDisable(int name) /*-{
       this.disable(name);
    }-*/;

    @Override
    public final void glDisableClientState(int state) {
       //not implemented
        LOG.debug("glDisableClientState");
    }

    @Override
    public final native void glDisableVertexAttribArray(int index) /*-{
       this.disableVertexAttribArray(index);
    }-*/;

    @Override
    public final native void glDrawArrays(int mode, int first, int count) /*-{
        this.drawArrays(mode, first, count);
    }-*/;

    @Override
    public final void glDrawBuffer(int buf) {
        //not implemented
        LOG.debug("glDrawBuffer");
    }

    @Override
    public final void glDrawBuffers(IntBuffer buf) {
        //not implemented
        LOG.debug("glDrawBuffers");
    }

    @Override
    public final native void glDrawElements(int mode, ShortBuffer srcIndexBuf) /*-{
       this.drawElements(mode, count, type, offset);
    }-*/;

    @Override
    public final native void glEnable(int name) /*-{
       this.enable(name);
    }-*/;

    @Override
    public final void glEnableClientState(int state) {
       //not implemented
        LOG.debug("glEnableClientState");
    }

    @Override
    public final native void glEnableVertexAttribArray(int index) /*-{
       this.enableVertexAttribArray(index);
    }-*/;

    @Override
    public final void glEnd() {
        //not implemented
        LOG.debug("glEnd");
    }

    @Override
    public final native void glFinish() /*-{
       this.finish();
    }-*/;

    @Override
    public final void glFrustum(double left, double right, double bottom, double top,
            double znear, double zfar) {
        //not implemented
        LOG.debug("glFrustum");
    }

    @Override
    public final native int glGetError() /*-{
       return this.getError();
    }-*/;

    @Override
    public final void glGetFloat(int name, FloatBuffer result) {
        //not implemented
        LOG.debug("glGetFloat");
    }

    @Override
    public final int glGetInteger(int pname) {
        //not implemented
        LOG.debug("glGetInteger");
        return 0;
    }

    @Override
    public final void glGetInteger(int pname, IntBuffer params) {
        //not implemented
        LOG.debug("glGetInteger");
    }

    @Override
    public final String glGetString(int glVendor) {
        //not implemented
        LOG.debug("glGetString");
        return null;
    }

    @Override
    public final void glGetShader(int shader, int status, Buffer buffer) {
        //not implemented
        LOG.debug("glGetShader");
    }

    @Override
    public final native String glGetShaderSource(int shader, IntBuffer length,
            ByteBuffer source) /*-{
       return this.getShaderSource(@com.jme3.renderer.gwt.GLGwtContextImpl::_shaders.get(shader));
    }-*/;

    @Override
    public final void glLoadIdentity() {
        //not implemented
        LOG.debug("glLoadIdentity");
    }

    @Override
    public final void glLoadMatrix(FloatBuffer m) {
        //not implemented
        LOG.debug("glLoadMatrix");
    }

    @Override
    public final void glMatrixMode(int mm) {
        //not implemented
        LOG.debug("glMatrixMode");
    }

    @Override
    public final void glMultMatrixf(float[] matrix, int ofs) {
        //not implemented
        LOG.debug("glMultMatrixf");
    }

    @Override
    public final void glOrtho(int left, int right, int bottom, int top, int near,
            int far) {
        //not implemented
        LOG.debug("glOrtho");
    }

    @Override
    public final void glReadBuffer(int buf) {
        //not implemented
        LOG.debug("glReadBuffer");
    }

    @Override
    public final void glReadBuffers(IntBuffer buf) {
        //not implemented
        LOG.debug("glReadBuffers");
    }

    @Override
    public final native void glPixelStorei(int pname, int param) /*-{
       this.pixelStorei(pname, param);
    }-*/;

    @Override
    public final void glPointParameterf(int id, float value) {
        //not implemented
        LOG.debug("glPointParameterf");
    }

    @Override
    public final void glPointSize(float value) {
        //not implemented
        LOG.debug("glPointSize");
    }

    @Override
    public final void glPolygonMode(int i, int j) {
        //not implemented
        LOG.debug("glPolygonMode");
    }

    @Override
    public final native void glPolygonOffset(float factor, float units) /*-{
       this.polygonOffset(factor, units);
    }-*/;

    @Override
    public final void glPopMatrix() {
        //not implemented
        LOG.debug("glPopMatrix");
    }

    @Override
    public final void glPushMatrix() {
        //not implemented
        LOG.debug("glPushMatrix");
    }

    @Override
    public final native void glReadPixels(int x, int y, int width, int height,
            int glBgr, int glUnsignedByte, ByteBuffer image) /*-{
                //TODO
       this.readPixels(x, y, width, height, format, type, pixels);
    }-*/;

    @Override
    public final void glRotatef(float angle, float x, float y, float z) {
        //not implemented
        LOG.debug("glRotatef");
    }

    @Override
    public final void glScalef(float x, float y, float z) {
        //not implemented
        LOG.debug("glScalef");
    }

    @Override
    public final native void glScissor(int x, int y, int width, int height) /*-{
       this.scissor(x, y, width, height);
    }-*/;

    @Override
    public final void glShadeModel(int sm) {
        //not implemented
        LOG.debug("glShadeModel");
    }

    @Override
    public final native void glStencilFunc(int func, int ref, int mask) /*-{
       this.stencilFunc(func, ref, mask);
    }-*/;

    @Override
    public final native void glStencilFuncSeparate(int face, int func, int ref, int mask) /*-{
       this.stencilFuncSeparate(face, func, ref, mask);
    }-*/;

    @Override
    public final native void glStencilMask(int mask) /*-{
       this.stencilMask(mask);
    }-*/;

    @Override
    public final native void glStencilOp(int fail, int zfail, int zpass) /*-{
       this.stencilOp(fail, zfail, zpass);
    }-*/;

    @Override
    public final native void glStencilOpSeparate(int face, int fail, int zfail, int zpass) /*-{
       this.stencilOpSeparate(face, fail, zfail, zpass);
    }-*/;

    @Override
    public final void glTexCoord2f(float x, float y) {
        //not implemented
        LOG.debug("glTexCoord2f");
    }

    @Override
    public final void glTexCoordPointer(int size, int byteStride, FloatBuffer buf) {
        //not implemented
        LOG.debug("glTexCoordPointer");
    }

    @Override
    public final void glTexEnvi(int glTextureEnv, int glTextureEnvMode, int mode) {
        //not implemented
        LOG.debug("glTexEnvi");
    }

    @Override
    public final native void glTexImage2D(int target, int level, int internalformat,
            int width, int height, int border, int format, int type,
            ByteBuffer pixels) /*-{
//		this.texImage2D(target, level, internalformat, width, height, border,
//				format, type, pixels);
//        LOG.debug("");
    }-*/;

    @Override
    public final native void glTexImage2D(int target, int level, int internalformat,
            int width, int height, int border, int format, int type,
            IntBuffer pixels) /*-{
//       this.texImage2D(target, level, internalformat, format, type, pixels);
//        LOG.debug("glTexImage2D");
    }-*/;

    @Override
    public final native void glTexParameterf(int target, int pname, float param) /*-{
       this.texParameterf(target, pname, param);
    }-*/;

    @Override
    public final native void glTexParameteri(int target, int glTextureMinFilter,
            int glFilterMin) /*-{
       this.texParameteri(target, glTextureMinFilter, glFilterMin);
    }-*/;

    @Override
    public final native void glTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int type,
            ByteBuffer pixels) /*-{
        this.texSubImage2D(target, level, xoffset, yoffset, width, height,
        format, type, pixels);
    }-*/;

    @Override
    public final native void glTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int type,
            IntBuffer pixels) /*-{
		this.texSubImage2D(target, level, xoffset, yoffset, width, height,
				format, type, pixels);
    }-*/;

    @Override
    public final void glTranslatef(float tx, float ty, float tz) {
        //not implemented
        LOG.debug("glTranslatef");
    }

    @Override
    public final void glVertex2f(int x, int y) {
        //not implemented
        LOG.debug("glVertex2f");
    }

    @Override
    public final void glVertex3f(float x, float y, float z) {
        //not implemented
        LOG.debug("glVertex3f");
    }

    @Override
    public final void glVertexAttribPointer(int bufIndex, int size, int type,
            boolean normalize, int byteStride, int byteOffset) {
        // TODO Auto-generated method stub
        LOG.debug("glVertexAttribPointer");
    }

    @Override
    public final void glVertexAttribPointer(int bufIndex, int size, int type,
            boolean normalize, int byteStride, int byteOffset,
            Buffer nioBuffer, int staticDrawId) {
        //not implemented
        LOG.debug("glVertexAttribPointer");
    }

    @Override
    public final void glVertexPointer(int size, int byteStride, FloatBuffer buf) {
        //not implemented
        LOG.debug("glVertexPointer");
    }

    @Override
    public final native void glViewport(int x, int y, int width,
            int height) /*-{
       this.viewport(x, y, width, height);
    }-*/;

    @Override
    public final boolean project(float objX, float objY, float objZ, int[] view,
            float[] win) {
        //not implemented
        LOG.debug("project");
        return false;
    }

    @Override
    public final void swapBuffers() {
        //not implemented
        LOG.debug("swapBuffers");
    }

    @Override
    public final native int glCreateProgram() /*-{
        @com.jme3.renderer.gwt.GLGwtContextImpl::_programs.add(this.createProgram());
        return @com.jme3.renderer.gwt.GLGwtContextImpl::_programs.size() - 1;
    }-*/;

    @Override
    public final native int createBuffer() /*-{
        @com.jme3.renderer.gwt.GLGwtContextImpl::_buffers.add(this.createBuffer());
        return @com.jme3.renderer.gwt.GLGwtContextImpl::_buffers.size() - 1;
    }-*/;

    @Override
    public final native int glCreateShader(int type) /*-{
        @com.jme3.renderer.gwt.GLGwtContextImpl::_shaders.add(this.createShader(type));
        return @com.jme3.renderer.gwt.GLGwtContextImpl::_shaders.size() - 1;
    }-*/;

    @Override
    public final void glGenBuffers(IntBuffer buffer) {
        //not implemented
        LOG.debug("glGenBuffers");
    }

    @Override
    public final native void glBindBuffer(int target, int bufferId) /*-{
       LOG.debug("glBindBuffer");
       this.bindBuffer(target,
           @com.jme3.renderer.gwt.GLGwtContextImpl::_buffers.get(bufferId));
    }-*/;

    @Override
    public final void glDeleteBuffers(IntBuffer buffer) {
        //not implemented
        LOG.debug("");
    }

    @Override
    public final native void glCompileShader(int shader)  /*-{
        this.compileShader(@com.jme3.renderer.gwt.GLGwtContextImpl::_shaders.get(shader));
    }-*/;

    @Override
    public final void glGetProgram(int programId, int status, Buffer buffer) {
        //not implemented
        LOG.debug("glGetProgram");
    }

    @Override
    public final native void glGetProgramInfoLog(int program, Object object, Buffer logBuf) /*-{
        //TODO convert result to buffer
        this.getProgramInfoLog(@com.jme3.renderer.gwt.GLGwtContextImpl::_programs.get(program));
    }-*/;

    @Override
    public final long glGetFramebufferAttachmentParameter(int target, int attachment,
            int pname) {
        // TODO Auto-generated method stub
        LOG.debug("glGetFramebufferAttachmentParameter");
        return 0;
    }

    @Override
    public final native int glGetUniformLocation(int program, Buffer buffer) /*-{
        //TODO
       return this.getUniformLocation(@com.jme3.renderer.gwt.GLGwtContextImpl::_programs.get(program), null);
    }-*/;

    @Override
    public final native void glUseProgram(int program) /*-{
       this.useProgram(@com.jme3.renderer.gwt.GLGwtContextImpl::_programs.get(program));
    }-*/;

    @Override
    public final native void glDeleteProgram(int program) /*-{
       this.deleteProgram(@com.jme3.renderer.gwt.GLGwtContextImpl::_programs.get(program));
    }-*/;

    @Override
    public final void glUniform1(int location, FloatBuffer v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform1");

    }

    @Override
    public final native void glUniform1f(int location, float x) /*-{
       uniform1f(@com.jme3.renderer.gwt.GLGwtContextImpl::_locations.get(location), x);
    }-*/;

    @Override
    public final void glUniform1fv(int location, Float32Array v) {
        glUniform1fv(location, (JavaScriptObject)v);
    }
    
    private final native void glUniform1fv(int location, JavaScriptObject v) /*-{
       uniform1fv(@com.jme3.renderer.gwt.GLGwtContextImpl::_locations.get(location), v);
    }-*/;

    @Override
    public final void glUniform1fv(int location, Collection<Float> v) {
        glUniform1fv(location,
                ArrayUtils.toJsArray(v.toArray(new Float[v.size()])));
    }

    @Override
    public final native void glUniform1i(int location, int x) /*-{
       this.uniform1i(@com.jme3.renderer.gwt.GLGwtContextImpl::_locations.get(location), x);
    }-*/;

    @Override
    public final void glUniform1iv(int location, Int32Array v) {
        uniform1iv(location, (JavaScriptObject)v);
    }
    
    private final native void uniform1iv(int location, JavaScriptObject v) /*-{
       this.uniform1iv(@com.jme3.renderer.gwt.GLGwtContextImpl::_locations.get(location), v);
    }-*/;

    @Override
    public final void glUniform1iv(int location, Collection<Float> v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform1iv");

    }

    @Override
    public final void glUniform2(int location, FloatBuffer v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform2");

    }

    @Override
    public final void glUniform2f(int location, float x, float y) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform2f");

    }

    @Override
    public final void glUniform2fv(int location, Float32Array v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform2fv");

    }

    @Override
    public final void glUniform2fv(int location, Collection<Float> v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform2fv");

    }

    @Override
    public final void glUniform2i(int location, int x, int y) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform2i");

    }

    @Override
    public final void glUniform2iv(int location, Int32Array v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform2iv");

    }

    @Override
    public final void glUniform2iv(int location, Collection<Long> v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform2iv");

    }

    @Override
    public final void glUniform3(int location, FloatBuffer v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform3");

    }

    @Override
    public final void glUniform3f(int location, float x, float y, float z) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform3f");

    }

    @Override
    public final void glUniform3fv(int location, Float32Array v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform3fv");

    }

    @Override
    public final void glUniform3fv(int location, Collection<Float> v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform3fv");

    }

    @Override
    public final void glUniform3i(int location, int x, int y, int z) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform3i");

    }

    @Override
    public final void glUniform3iv(int location, Int32Array v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform3iv");

    }

    @Override
    public final void glUniform3iv(int location, Collection<Long> v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform3iv");

    }

    @Override
    public final void glUniform4(int location, FloatBuffer v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform4");

    }

    @Override
    public final void glUniform4f(int location, float x, float y, float z, float w) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform4f");

    }

    @Override
    public final void glUniform4fv(int location, Float32Array v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform4fv");

    }

    @Override
    public final void glUniform4fv(int location, Collection<Float> v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform4fv");

    }

    @Override
    public final void glUniform4i(int location, int x, int y, int z, int w) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform4i");

    }

    @Override
    public final void glUniform4iv(int location, Int32Array v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform4iv");

    }

    @Override
    public final void glUniform4iv(int location, Collection<Long> v) {
        // TODO Auto-generated method stub
        LOG.debug("glUniform4iv");

    }

    @Override
    public final void glUniformMatrix2fv(int location, boolean transpose,
            Float32Array value) {
        // TODO Auto-generated method stub
        LOG.debug("glUniformMatrix2fv");

    }

    @Override
    public final void glUniformMatrix2fv(int location, boolean transpose,
            Collection<Float> value) {
        // TODO Auto-generated method stub
        LOG.debug("glUniformMatrix2fv");

    }

    @Override
    public final void glUniformMatrix3(int location, boolean transpose,
            FloatBuffer value) {
        // TODO Auto-generated method stub
        LOG.debug("glUniformMatrix3");

    }

    @Override
    public final void glUniformMatrix3fv(int location, boolean transpose,
            Float32Array value) {
        // TODO Auto-generated method stub
        LOG.debug("glUniformMatrix3fv");

    }

    @Override
    public final void glUniformMatrix3fv(int location, boolean transpose,
            Collection<Float> value) {
        // TODO Auto-generated method stub
        LOG.debug("glUniformMatrix3fv");

    }

    @Override
    public final void glUniformMatrix4(int location, boolean transpose,
            FloatBuffer value) {
        // TODO Auto-generated method stub
        LOG.debug("glUniformMatrix4");

    }

    @Override
    public final void glUniformMatrix4fv(int location, boolean transpose,
            Float32Array value) {
        // TODO Auto-generated method stub
        LOG.debug("glUniformMatrix4fv");

    }

    @Override
    public final void glUniformMatrix4fv(int location, boolean transpose,
            Collection<Float> value) {
        // TODO Auto-generated method stub
        LOG.debug("glUniformMatrix4fv");

    }

    @Override
    public final native void glGenerateMipmap(int target) /*-{
       this.generateMipmap(target);
    }-*/;

    @Override
    public final void glGenerateMipmapEXT(int target) {
        // TODO Auto-generated method stub
        LOG.debug("glGenerateMipmapEXT");

    }

    @Override
    public final native void glDeleteRenderbuffer(WebGLRenderbuffer renderbuffer) /*-{
       this.deleteRenderbuffer(renderbuffer);
    }-*/;

    @Override
    public final native int glGetAttribLocation(int program, Buffer buffer) /*-{
        //TODO convert buffer to string
       return this.getAttribLocation(@com.jme3.renderer.gwt.GLGwtContextImpl::_programs.get(program), "");
    }-*/;

    @Override
    public final native void glShaderSource(int shaderId, Buffer source) /*-{
        //TODO convert source to string
        LOG.debug("glShaderSource");
        this.shaderSource(@com.jme3.renderer.gwt.GLGwtContextImpl::_shaders.get(shader), "");
    }-*/;

    @Override
    public final native void glGetShaderInfoLog(int shader, Object object, Buffer logBuf) /*-{
        this.getShaderInfoLog(@com.jme3.renderer.gwt.GLGwtContextImpl::_shaders.get(shader));
    }-*/;

    @Override
    public final native void glLinkProgram(int program) /*-{
       this.linkProgram(@com.jme3.renderer.gwt.GLGwtContextImpl::_programs.get(program));
    }-*/;

    @Override
    public final native void glDetachShader(int program, int shader) /*-{
        this.detachShader(@com.jme3.renderer.gwt.GLGwtContextImpl::_programs.get(program),
        @com.jme3.renderer.gwt.GLGwtContextImpl::_shaders.get(shader));
    }-*/;

    @Override
    public final void glGenTextures(Buffer buffer) {
        // TODO Auto-generated method stub
        LOG.debug("glGenTextures");

    }
    
    @Override
    public final void glGenFramebuffers(Buffer buffer) {
        // TODO Auto-generated method stub
        LOG.debug("glGenFramebuffers");

    }

    @Override
    public final void glGenFramebuffersEXT(Buffer buffer) {
        glGenFramebuffers(buffer);
    }

    @Override
    public final native void glBindFramebufferEXT(int n, int buffer) /*-{
       this.bindFramebuffer(target,
          @com.jme3.renderer.gwt.GLGwtContextImpl::_frameBuffers.get(buffer));
    }-*/;

    @Override
    public final native void glLineWidth(float lineWidth) /*-{
       this.lineWidth(lineWidth);
    }-*/;

    @Override
    public final boolean glGetBoolean(int glDoublebuffer) {
        // TODO Auto-generated method stub
        LOG.debug("glGetBoolean");
        return false;
    }

    @Override
    public final void glDeleteRenderbuffersEXT(Buffer buffer) {
        // TODO Auto-generated method stub
        LOG.debug("glDeleteRenderbuffersEXT");
    }

    @Override
    public final native void glDeleteFramebuffersEXT(Buffer buffer) /*-{
       this.deleteFramebuffer(framebuffer);
    }-*/;

    @Override
    public final void glDrawRangeElements(int elMode, int i, int vertCount,
            int elementLength, int fmt, int curOffset) {
        // TODO Auto-generated method stub
        LOG.debug("glDrawRangeElements");

    }

    @Override
    public final void glBlitFramebufferEXT(int i, int j, int srcW, int srcH, int k,
            int l, int dstW, int dstH, int mask, int glNearest) {
        // TODO Auto-generated method stub
        LOG.debug("glBlitFramebufferEXT");

    }

    @Override
    public final native int glCheckFramebufferStatusEXT(int glFramebufferExt) /*-{
       return this.checkFramebufferStatus(@com.jme3.renderer.gwt.GLGwtContextImpl::_frameBuffers.get(glFramebufferExt));
    }-*/;

    @Override
    public final native void glFramebufferRenderbuffer(int target, int attachment,
            int renderBufferTarget, int renderBuffer) /*-{
       this.framebufferRenderbuffer(target, attachment, renderbuffertarget,
          @com.jme3.renderer.gwt.GLGwtContextImpl::_renderBuffers.get(renderBuffer));
    }-*/;

    @Override
    public final native void glFramebufferRenderbufferEXT(int target, int attachment,
            int renderBufferTarget, int renderBuffer) /*-{
       this.framebufferTexture2D(target, attachment, renderbuffertarget,
           @com.jme3.renderer.gwt.GLGwtContextImpl::_renderBuffers.get(renderBuffer));
    }-*/;

    @Override
    public final native void glFramebufferTexture2DEXT(int target, int attachment,
            int renderbuffertarget, int texture, int level) /*-{
        return this.framebufferTexture2D(target, attachment,
            textarget, @com.jme3.renderer.gwt.GLGwtContextImpl::_textures.get(texture), level);
    }-*/;

}
