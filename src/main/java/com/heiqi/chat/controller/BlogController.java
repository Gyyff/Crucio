package com.heiqi.chat.controller;

import com.heiqi.chat.Utils.UploadUtil;
import com.heiqi.chat.common.Result;
import com.heiqi.chat.common.SensitiveWordsChecker;
import com.heiqi.chat.entity.BaseUser;
import com.heiqi.chat.entity.Blog;
import com.heiqi.chat.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/user/blog")
public class BlogController {
    private final BlogService blogService;
    private final SensitiveWordsChecker sensitiveWordsChecker;

    @Autowired
    public BlogController(BlogService blogService, SensitiveWordsChecker sensitiveWordsChecker) {
        this.blogService = blogService;
        this.sensitiveWordsChecker = sensitiveWordsChecker;
    }


    @GetMapping("/getBlogByBlogID/{BlogID}")
    public Blog getBlogByBlogID(@PathVariable("BlogID") int BlogID) {
        return blogService.findByBlogID(BlogID);
    }

    @GetMapping("/getBlogByUserID/{UserID}")
    public Blog getBlogByUserID(@PathVariable("UserID") int UserID) {
        return blogService.findByUserID(UserID);
    }

    // 这里写更多的 getter 函数...
    @PostMapping("/insertBlog")
    public Result insertBlog(@RequestBody Blog blog) {
        Blog blogS = blogService.insertBlog(blog);
        return Result.success(blogS);
    }

    @DeleteMapping("/deleteBlogByUserID/{UserID}")
    public void deleteBlogByUserID(@PathVariable("UserID") int UserID, BaseUser baseUser) {
        blogService.deleteBlogByUserID(UserID);
    }


    @PutMapping("/updateContentIntroductionByUserID/{UserID}")
    public Result updateContentIntroductionByUserID(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContentIntroductionByUserID(UserID, str);
            return Result.success(blog);
        }
        if (blogService.findByUserID(UserID) != null) {
            return Result.success(blogService.updateContentIntroductionByUserID(UserID, Content));
        } else {
            return Result.error("没找到该blog");
        }
    }

    @PutMapping("/updateContentDreamByUserID/{UserID}")
    public Result updateContentDreamByUserID(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContentDreamByUserID(UserID, str);
            return Result.success(blog);
        }

        if (blogService.findByUserID(UserID) != null) {
            return Result.success(blogService.updateContentDreamByUserID(UserID, Content));
        } else {
            return Result.error("没找到该blog");
        }
    }

    @PutMapping("/updateContent1/{UserID}")
    public Result updateContent1(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent1(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent1(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent2/{UserID}")
    public Result updateContent2(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent2(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent2(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent3/{UserID}")
    public Result updateContent3(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent3(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent3(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent4/{UserID}")
    public Result updateContent4(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent4(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent4(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent5/{UserID}")
    public Result updateContent5(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent5(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent5(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent6/{UserID}")
    public Result updateContent6(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent6(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent6(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent7/{UserID}")
    public Result updateContent7(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent7(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent7(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent8/{UserID}")
    public Result updateContent8(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent8(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent8(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent9/{UserID}")
    public Result updateContent9(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent9(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent9(UserID, Content);
        return Result.success(blog);
    }

    @PutMapping("/updateContent10/{UserID}")
    public Result updateContent10(@PathVariable("UserID") int UserID, @RequestBody String Content, BaseUser baseUser) {
//        if (sensitiveWordsChecker.containsSensitiveWords(Content)) {
//            return Result.error("该文案中存在敏感词汇，请重新填写");
//        }
        if (Content.equals("heiqi2023")){
            String str = new String();
            str="";
            Blog blog = blogService.updateContent10(UserID, str);
            return Result.success(blog);
        }
        Blog blog = blogService.updateContent10(UserID, Content);
        return Result.success(blog);
    }


    @PutMapping("/updatePhoto1/{UserID}")
    public Result updatePhoto1(@PathVariable("UserID") int UserID, @RequestBody MultipartFile file) throws IOException {
        String path = UploadUtil.uploadImage(file);
        Blog blog = blogService.updatePhoto1(UserID, path);
        return Result.success(blog);
    }

    @PutMapping("/updatePhoto2/{UserID}")
    public Result updatePhoto2(@PathVariable("UserID") int UserID, @RequestBody MultipartFile file, BaseUser baseUser) throws IOException {
        String path = UploadUtil.uploadImage(file);
        Blog blog = blogService.updatePhoto2(UserID, path);
        return Result.success(blog);
    }

    @PutMapping("/updatePhoto3/{UserID}")
    public Result updatePhoto3(@PathVariable("UserID") int UserID, @RequestBody MultipartFile file, BaseUser baseUser) throws IOException {
        String path = UploadUtil.uploadImage(file);
        Blog blog = blogService.updatePhoto3(UserID, path);
        return Result.success(blog);
    }

    @PutMapping("/updatePhoto4/{UserID}")
    public Result updatePhoto4(@PathVariable("UserID") int UserID, @RequestBody MultipartFile file, BaseUser baseUser) throws IOException {
        String path = UploadUtil.uploadImage(file);
        Blog blog = blogService.updatePhoto4(UserID, path);
        return Result.success(blog);
    }

    @PutMapping("/updatePhoto5/{UserID}")
    public Result updatePhoto5(@PathVariable("UserID") int UserID, @RequestBody MultipartFile file, BaseUser baseUser) throws IOException {
        String path = UploadUtil.uploadImage(file);
        Blog blog = blogService.updatePhoto5(UserID, path);
        return Result.success(blog);
    }

    @PutMapping("/updatePhoto6/{UserID}")
    public Result updatePhoto6(@PathVariable("UserID") int UserID, @RequestBody MultipartFile file, BaseUser baseUser) throws IOException {
        String path = UploadUtil.uploadImage(file);
        Blog blog = blogService.updatePhoto6(UserID, path);
        return Result.success(blog);
    }

    @DeleteMapping("/deletePhoto1ByUserID/{UserId}")
    public Result deletePhoto1ByUserID(@PathVariable("UserId") int UserId){
        return blogService.deletePhoto1ByUserID(UserId);
    }

    @DeleteMapping("/deletePhoto2ByUserID/{UserId}")
    public Result deletePhoto2ByUserID(@PathVariable("UserId") int UserId){
        return blogService.deletePhoto2ByUserID(UserId);
    }

    @DeleteMapping("/deletePhoto3ByUserID/{UserId}")
    public Result deletePhoto3ByUserID(@PathVariable("UserId") int UserId){
        return blogService.deletePhoto3ByUserID(UserId);
    }

    @DeleteMapping("/deletePhoto4ByUserID/{UserId}")
    public Result deletePhoto4ByUserID(@PathVariable("UserId") int UserId){
        return blogService.deletePhoto4ByUserID(UserId);
    }

    @DeleteMapping("/deletePhoto5ByUserID/{UserId}")
    public Result deletePhoto5ByUserID(@PathVariable("UserId") int UserId){
        return blogService.deletePhoto5ByUserID(UserId);
    }

    @DeleteMapping("/deletePhoto6ByUserID/{UserId}")
    public Result deletePhoto6ByUserID(@PathVariable("UserId") int UserId){
        return blogService.deletePhoto6ByUserID(UserId);
    }

    @DeleteMapping("/deleteContentIntroductionByUserID/{UserId}")
    public Result deleteContentIntroductionByUserID(@PathVariable("UserId") int UserId){
        return blogService.deleteContentIntroductionByUserID(UserId);
    }

    @DeleteMapping("/deleteContentDreamByUserID/{UserId}")
    public Result deleteContentDreamByUserID(@PathVariable("UserId") int UserId){
        return blogService.deleteContentDreamByUserID(UserId);
    }

    @DeleteMapping("/deleteContent1/{UserId}")
    public Result deleteContent1(@PathVariable("UserId") int UserId){
        return blogService.deleteContent1(UserId);
    }

    @DeleteMapping("/deleteContent2/{UserId}")
    public Result deleteContent2(@PathVariable("UserId") int UserId){
        return blogService.deleteContent2(UserId);
    }

    @DeleteMapping("/deleteContent3/{UserId}")
    public Result deleteContent3(@PathVariable("UserId") int UserId){
        return blogService.deleteContent3(UserId);
    }

    @DeleteMapping("/deleteContent4/{UserId}")
    public Result deleteContent4(@PathVariable("UserId") int UserId){
        return blogService.deleteContent4(UserId);
    }

    @DeleteMapping("/deleteContent5/{UserId}")
    public Result deleteContent5(@PathVariable("UserId") int UserId){
        return blogService.deleteContent5(UserId);
    }


    @DeleteMapping("/deleteContent6/{UserId}")
    public Result deleteContent6(@PathVariable("UserId") int UserId){
        return blogService.deleteContent6(UserId);
    }

    @DeleteMapping("/deleteContent7/{UserId}")
    public Result deleteContent7(@PathVariable("UserId") int UserId){
        return blogService.deleteContent7(UserId);
    }

    @DeleteMapping("/deleteContent8/{UserId}")
    public Result deleteContent8(@PathVariable("UserId") int UserId){
        return blogService.deleteContent8(UserId);
    }

    @DeleteMapping("/deleteContent9/{UserId}")
    public Result deleteContent9(@PathVariable("UserId") int UserId){
        return blogService.deleteContent9(UserId);
    }

    @DeleteMapping("/deleteContent10/{UserId}")
    public Result deleteContent10(@PathVariable("UserId") int UserId){
        return blogService.deleteContent10(UserId);
    }

    // 这里写更多的 setter 函数...
}
