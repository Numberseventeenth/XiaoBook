package com.xiao.controller;

import com.xiao.domain.Book;
import com.xiao.domain.Member;
import com.xiao.service.BookService;
import com.xiao.service.MemberService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/export")
public class ExportExcel {

    @Autowired
    private BookService bookService;
    @Autowired
    private MemberService memberService;

    @RequestMapping("/exportExcelByBook.do")
    public void export(HttpServletResponse response){

        List<Book> books = bookService.findAll();
        HSSFWorkbook wk = new HSSFWorkbook();
        HSSFSheet sheet = wk.createSheet("图书信息表");
        for (int i = 0; i < 9; i++) {
            sheet.setColumnWidth(i, 3000);
        }

        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell =row1.createCell(0);
        cell.setCellValue("图书信息表");
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,9));
        HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("ISBN");
        row2.createCell(1).setCellValue("图书名称");
        row2.createCell(2).setCellValue("价格");
        row2.createCell(3).setCellValue("出版社");
        row2.createCell(4).setCellValue("作者");
        row2.createCell(5).setCellValue("类别");
        row2.createCell(6).setCellValue("出版年份");
        row2.createCell(7).setCellValue("库存");
        row2.createCell(8).setCellValue("入库时间");
        row2.createCell(9).setCellValue("借出数量");

        for (int i = 0; i < books.size(); i++) {
            HSSFRow row = sheet.createRow(i+2);
            row.createCell(0).setCellValue(books.get(i).getBook_isbn());
            row.createCell(1).setCellValue(books.get(i).getBook_name());
            row.createCell(2).setCellValue(books.get(i).getBook_price());
            row.createCell(3).setCellValue(books.get(i).getBook_public());
            row.createCell(4).setCellValue(books.get(i).getBook_author());
            row.createCell(5).setCellValue(books.get(i).getCategory().getC_name());
            row.createCell(6).setCellValue(books.get(i).getBook_year());
            row.createCell(7).setCellValue(books.get(i).getBook_count());
            row.createCell(8).setCellValue(books.get(i).getBookDateStr());
            row.createCell(9).setCellValue(books.get(i).getBook_borrow());
        }
        try{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String str = sdf.format(date);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition","attachment;filename=" + str + ".xls");
            response.flushBuffer();
            wk.write(response.getOutputStream());
            wk.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/exportExcelByMember.do")
    public void exportExcelByMember(HttpServletResponse response) throws Exception {
        List<Member> members = memberService.findAll();

        HSSFWorkbook wk = new HSSFWorkbook();
        HSSFSheet sheet = wk.createSheet("会员表");
        for (int i = 0; i < 12; i++) {
            sheet.setColumnWidth(i, 3000);
        }

        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell =row1.createCell(0);
        cell.setCellValue("图书信息表");
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,12));
        HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("ID");
        row2.createCell(1).setCellValue("会员名字");
        row2.createCell(2).setCellValue("性别");
        row2.createCell(3).setCellValue("学号");
        row2.createCell(4).setCellValue("班级");
        row2.createCell(5).setCellValue("联系方式");
        row2.createCell(6).setCellValue("系别");
        row2.createCell(7).setCellValue("描述");
        row2.createCell(8).setCellValue("创建时间");
        row2.createCell(9).setCellValue("状态");
        row2.createCell(10).setCellValue("会员等级");
        row2.createCell(11).setCellValue("积分");

        for (int i = 0; i < members.size(); i++) {
            HSSFRow row = sheet.createRow(i+2);
            row.createCell(0).setCellValue(members.get(i).getM_id());
            row.createCell(1).setCellValue(members.get(i).getM_name());
            row.createCell(2).setCellValue(members.get(i).getSexStr());
            row.createCell(3).setCellValue(members.get(i).getM_idcard());
            row.createCell(4).setCellValue(members.get(i).getM_class());
            row.createCell(5).setCellValue(members.get(i).getM_tel());
            row.createCell(6).setCellValue(members.get(i).getM_dept());
            row.createCell(7).setCellValue(members.get(i).getM_desc());
            row.createCell(8).setCellValue(members.get(i).getDateStr());
            row.createCell(9).setCellValue(members.get(i).getStatusStr());
            row.createCell(10).setCellValue(members.get(i).getGradeStr());
            row.createCell(11).setCellValue(members.get(i).getM_integral());
        }
        try{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String str = sdf.format(date);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition","attachment;filename=" + str + ".xls");
            response.flushBuffer();
            wk.write(response.getOutputStream());
            wk.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
